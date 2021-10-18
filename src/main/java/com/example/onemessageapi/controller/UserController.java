package com.example.onemessageapi.controller;

import java.util.Optional;
import java.util.UUID;

import com.example.onemessageapi.api.MeApi;
import com.example.onemessageapi.model.response.GetMeResponse;
import com.example.onemessageapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class UserController implements MeApi {

  @Autowired
  private final NativeWebRequest request;

  @Autowired
  private UserService userService;

  public UserController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<GetMeResponse> getMe() {
    // IDの取得
    var userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();

    var user = userService.getLoginUser(userId).get();

    var getMeResponse = new GetMeResponse();
    getMeResponse.setName(user.getName());
    getMeResponse.setId(UUID.fromString(user.getId()));
    getMeResponse.setEmail(user.getEmail());

    return new ResponseEntity<GetMeResponse>(getMeResponse, HttpStatus.OK);
  }
}
