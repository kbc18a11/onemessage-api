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
import twitter4j.Twitter;
import twitter4j.TwitterException;

@SpringBootTest
public class TwitterServiceTest {

  @Autowired
  private TwitterService twitterService;

  @MockBean
  private TwitterRepository repository;

  @MockBean
  private Twitter twitter;

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

  @Test
  public void Twitterアカウント情報の取得の検証() throws TwitterException {
    /*
     * var user = new User(); user.setId("tesetId");
     * 
     * var twitterAccount = new TwitterAccount(); twitterAccount.setAccessToken("testToken");
     * twitterAccount.setSecretKey("testSecretKey"); twitterAccount.setUser(user);
     * 
     * // ユーザーIDが一致するデータを検索する処理をモック化
     * when(repository.findByUserId(user.getId())).thenReturn(Optional.ofNullable(twitterAccount));
     * 
     * // Twitterアカウント情報取得処理をモック化 when(twitter.verifyCredentials()).thenReturn(null);
     * 
     * twitterService.getAccountFindByUserId(user.getId());
     * 
     * verify(repository, times(1)).findByUserId(user.getId()); verify(twitter,
     * times(1)).setOAuthAccessToken( new AccessToken(twitterAccount.getAccessToken(),
     * twitterAccount.getSecretKey())); verify(twitter, times(1)).verifyCredentials();
     */
  }

  @Test
  public void アクセストークンと秘密鍵を削除の検証() {
    var user = new User();
    user.setId("tesetId");

    twitterService.deleteAccountTokenAndSecretKeyByUserId(user.getId());

    verify(repository, times(1)).deleteByUserId(user.getId());
  }
}
