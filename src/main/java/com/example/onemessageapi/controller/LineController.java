package com.example.onemessageapi.controller;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import javax.validation.Valid;
import com.example.onemessageapi.service.LineService;
import com.example.onemessageapi.service.UserService;
import org.openapitools.api.LineApi;
import org.openapitools.model.CreateLineAccountRequest;
import org.openapitools.model.CreateLineAccountResponse;
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

  @Override
  public ResponseEntity<CreateLineAccountResponse> createLineAccount(@Valid CreateLineAccountRequest createLineAccountRequest) {
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
   * アカウント情報を削除
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

      // 子であるLINEアカウント情報を削除するため、nullを代入
      user.setLineAccount(null);

      lineService.deleteAccountInfo(lineAccount);

      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
