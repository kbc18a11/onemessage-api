package com.example.onemessageapi.service;

import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public User getLoginUser(String userId) {
    return repository.findById(userId).get();
  }
}
