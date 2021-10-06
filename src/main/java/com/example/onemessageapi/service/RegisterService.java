package com.example.onemessageapi.service;

import com.example.onemessageapi.entitys.User;
import com.example.onemessageapi.model.request.CreateMeRequest;
import com.example.onemessageapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  @Autowired
  private UserRepository repository;

  /**
   * ユーザー登録
   * 
   * @param createMeRequest
   */
  public void register(CreateMeRequest createMeRequest) throws Exception {
    // メールアドレスが存在しているか
    if (repository.findByEmail(createMeRequest.getEmail()).size() > 0) {
      throw new Exception("登録済みのメールアドレスです");
    }
  }
}
