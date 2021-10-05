package com.example.onemessageapi.controller;

import java.util.UUID;

import com.example.onemessageapi.api.MeApi;
import com.example.onemessageapi.model.response.GetMeResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController implements MeApi {
  @Override
  public ResponseEntity<GetMeResponse> getMe() {
    var getMeResponse = new GetMeResponse();
    getMeResponse.setDisplayName("うんこ");
    getMeResponse.setId(UUID.randomUUID());

    // TODO Auto-generated method stub
    return new ResponseEntity<GetMeResponse>(getMeResponse, HttpStatus.OK);
  }
}
