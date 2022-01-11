package com.example.onemessageapi.controller;

import java.util.Optional;
import com.example.onemessageapi.service.LineService;
import com.example.onemessageapi.service.UserService;
import org.openapitools.api.LineApi;
import org.openapitools.api.LineApiController;
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
      user.setLineAccount(null);

      lineService.deleteAccountInfo(lineAccount);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
