package com.example.onemessageapi.service;

import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.repository.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

  @Autowired
  private TwitterRepository repository;

  /**
   * アクセストークンと秘密鍵を保存
   * 
   * @param account
   */
  public void saveAccountTokenAndSecretKey(TwitterAccount account) {
    repository.save(account);
  }
}
