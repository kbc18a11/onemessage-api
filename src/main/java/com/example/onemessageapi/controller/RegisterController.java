package com.example.onemessageapi.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.example.onemessageapi.api.RegisterApi;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.model.request.CreateMeRequest;
import com.example.onemessageapi.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class RegisterController implements RegisterApi {
  @Autowired
  private RegisterService registerService;

  @Override
  public ResponseEntity<Void> createMe(@Valid CreateMeRequest createMeRequest) {
    // ユーザーモデルにリクエスト情報をセット
    var user = new User();
    user.setName(createMeRequest.getName());
    user.setPassword(createMeRequest.getPassword());
    user.setEmail(createMeRequest.getEmail());

    try {
      // 情報のセットされたユーザーモデルを登録させる
      registerService.register(user);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
