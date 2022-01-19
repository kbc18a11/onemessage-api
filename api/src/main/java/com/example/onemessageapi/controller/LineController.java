package com.example.onemessageapi.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import javax.validation.Valid;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.service.LineService;
import com.example.onemessageapi.service.UserService;
import org.openapitools.api.LineApi;
import org.openapitools.model.CreateLineAccountRequest;
import org.openapitools.model.CreateLineAccountResponse;
import org.openapitools.model.GetLineAccountFriendsResponse;
import org.openapitools.model.GetLineAccountFriendsResponseFriends;
import org.openapitools.model.GetLineAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LineController implements LineApi {

  @Autowired
  private LineService lineService;

  @Autowired
  private final NativeWebRequest request;

  @Autowired
  private UserService userService;

  public LineController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  /**
   * LINEBOT情報の登録
   */
  @Override
  public ResponseEntity<CreateLineAccountResponse> createLineAccount(
      @Valid CreateLineAccountRequest createLineAccountRequest) {
    // ユーザー情報の取得
    var user = userService
        .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

    try {
      var lineBotInfo = lineService.createAccountInfo(createLineAccountRequest.getChannelToken(), user);

      var response = new CreateLineAccountResponse();
      response.setDisplayName(lineBotInfo.getDisplayName());
      response.setPictureUrl(lineBotInfo.getPictureUrl());

      return new ResponseEntity<CreateLineAccountResponse>(response, HttpStatus.CREATED);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * LINEBOT情報の取得
   */
  @Override
  public ResponseEntity<GetLineAccountResponse> getLineAccount() {
    User user;

    try {
      user = userService
          .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

      if (user.getLineAccount() == null)
        throw new Exception();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "LINEアカウント情報が存在しません");
    }

    try {
      var lineBotInfo = lineService.getBotInfo(user.getLineAccount().getChannelToken());

      var response = new GetLineAccountResponse();
      response.setDisplayName(lineBotInfo.getDisplayName());
      response.setPictureUrl(lineBotInfo.getPictureUrl());

      return new ResponseEntity<GetLineAccountResponse>(response, HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * LINEBOT情報を削除
   */
  @Override
  public ResponseEntity<Void> deleteLineAccount() {
    // ユーザー情報の取得
    var user = userService
        .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

    try {
      if (user.getLineAccount() == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      var lineAccount = user.getLineAccount();

      // 子であるLINEBOT情報を削除するため、nullを代入
      user.setLineAccount(null);

      lineService.deleteAccountInfo(lineAccount);

      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * 友達ID一覧取得
   */
  @Override
  public ResponseEntity<GetLineAccountFriendsResponse> getLineAccountFriends(@Valid Integer limit) {
    User user;

    try {
      // ユーザー情報の取得
      user = userService
          .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

      // LINEBOTが紐付けられていない場合
      if (user.getLineAccount() == null)
        throw new Exception();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "LINEアカウント情報が存在しません");
    }


    try {
      // friends一覧取得
      var friendIds = lineService.getFriendIds(user.getLineAccount().getChannelToken());

      var response = new GetLineAccountFriendsResponse();

      // ID一覧をレスポンスオブジェクトに格納
      Arrays.stream(friendIds.getUserIds())
          .forEach(id -> {
            var friend = new GetLineAccountFriendsResponseFriends();
            friend.setId(id);
            response.addFriendsItem(friend);
          });
      response.setTotal(friendIds.getUserIds().length);

      return new ResponseEntity<GetLineAccountFriendsResponse>(response, HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
