package com.example.onemessageapi.service;

import javax.transaction.Transactional;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.repository.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

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

  /**
   * Twitterアカウント情報の取得
   * 
   * @param userId
   * @return
   * @throws TwitterException
   */
  public User getAccountFindByUserId(String userId) throws TwitterException {

    // アクセストークンと秘密鍵を取得
    var twitterAccount = repository.findByUserId(userId).get();

    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthAccessToken(
        new AccessToken(twitterAccount.getAccessToken(), twitterAccount.getSecretKey()));

    return twitter.verifyCredentials();
  }

  /**
   * アクセストークンと秘密鍵を削除
   * 
   * @param userId
   */
  @Transactional
  public void deleteAccountTokenAndSecretKeyByUserId(String userId) {
    repository.deleteByUserId(userId);
  }
}
