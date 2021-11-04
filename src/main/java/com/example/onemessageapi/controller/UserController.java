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
import org.springframework.web.server.ResponseStatusException;

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
    var userId = "";

    try {
      // IDの取得
      userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    var user = userService.getLoginUser(userId);

    var response = new GetMeResponse();
    response.setName(user.getName());
    response.setId(UUID.fromString(user.getId()));
    response.setEmail(user.getEmail());

    return new ResponseEntity<GetMeResponse>(response, HttpStatus.OK);
  }
}
