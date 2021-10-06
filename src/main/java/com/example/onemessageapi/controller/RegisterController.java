package com.example.onemessageapi.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.example.onemessageapi.api.RegisterApi;
import com.example.onemessageapi.model.request.CreateMeRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterController implements RegisterApi {

  @Override
  public ResponseEntity<Void> createMe(@Valid CreateMeRequest createMeRequest) {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
