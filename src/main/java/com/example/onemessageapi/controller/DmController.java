package com.example.onemessageapi.controller;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import javax.validation.Valid;
import com.example.onemessageapi.service.DmService;
import com.example.onemessageapi.service.LineService;
import com.example.onemessageapi.service.TwitterService;
import com.example.onemessageapi.service.UserService;
import org.openapitools.api.DmApi;
import org.openapitools.model.GetDmResponse;
import org.openapitools.model.GetDmResponseMessages;
import org.openapitools.model.PostDmRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;
import twitter4j.TwitterException;

@RestController
public class DmController implements DmApi {

  @Autowired
  private final NativeWebRequest request;

  @Autowired
  private TwitterService twitterService;

  @Autowired
  private UserService userService;

  @Autowired
  private LineService lineService;

  @Autowired
  private DmService dmService;

  public DmController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  /**
   * DMを送信する
   */
  @Override
  public ResponseEntity<Void> postDm(@Valid PostDmRequest postDmRequest) {
    // ユーザー情報の取得
    var user = userService
        .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

    postDmRequest.getSendingAddresses().forEach(sendingAddresse -> {
      switch (sendingAddresse.getPlatformType()) {
        case TWITTER:
          try {
            twitterService.postDm(
                user.getTwitterAccounts(),
                postDmRequest.getMessage(),
                sendingAddresse
                    .getAddresses()
                    .stream()
                    .mapToLong(address -> Long.parseLong(address.getId()))
                    .toArray());
          } catch (TwitterException e) {
            System.err.println(e);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
          }
          break;
        case LINE:
          try {
            var ids = new ArrayList<String>();
            sendingAddresse
                .getAddresses()
                .stream()
                .forEach(address -> ids.add(address.getId()));

            lineService.postDm(
                user.getLineAccount().getChannelToken(),
                postDmRequest.getMessage(),
                ids.toArray(new String[sendingAddresse.getAddresses().size()]));
          } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
          }
          break;
        default:
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
    });

    try {
      // 送信メッセージ履歴を保存
      dmService.createDmHistory(postDmRequest.getMessage(), user);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<GetDmResponse> getDm() {
    try {
      // メッセージ送信履歴を取得
      var histories = dmService.getHistories();

      var response = new GetDmResponse();

      histories
          .stream()
          .forEach(history -> {
            // レスポンス用の送信メッセージ履歴オブジェクトの形成
            var responseMessagesItem = new GetDmResponseMessages();
            responseMessagesItem.setMessage(history.getMessage());
            var instant = history.getCreateAt().toInstant();
            var zone = ZoneId.systemDefault();
            responseMessagesItem.setPostDateTime(OffsetDateTime.ofInstant(instant, zone));

            response.addMessagesItem(responseMessagesItem);
          });

      return new ResponseEntity<GetDmResponse>(response, HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
