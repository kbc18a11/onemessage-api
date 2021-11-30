package com.example.onemessageapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.TwitterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TwitterServiceTest {

  @Autowired
  private TwitterService twitterService;

  @MockBean
  private TwitterRepository repository;

  @Test
  public void アクセストークンと秘密鍵を保存の検証() {
    var user = new User();
    user.setId("tesetId");

    var twitterAccount = new TwitterAccount();
    twitterAccount.setAccessToken("testToken");
    twitterAccount.setSecretKey("testSecretKey");
    twitterAccount.setUser(user);

    twitterService.saveAccountTokenAndSecretKey(twitterAccount);

    verify(repository, times(1)).save(twitterAccount);
  }
}
