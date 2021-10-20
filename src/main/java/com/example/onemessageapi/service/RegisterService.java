package com.example.onemessageapi.service;

import java.util.UUID;

import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  @Autowired
  private UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * ユーザー登録
   * 
   * @param createMeRequest
   */
  public void register(User user) throws Exception {
    // メールアドレスが存在しているか
    if (repository.existsByEmail(user.getEmail())) {
      throw new Exception("登録済みのメールアドレスです");
    }

    // UUIDの発行
    user.setId(UUID.randomUUID().toString());

    // パスワードをハッシュ化
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    // ユーザー登録を行う
    repository.save(user);
  }
}
