package com.example.onemessageapi.service;

import java.util.ArrayList;
import javax.transaction.Transactional;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.repository.TwitterRepository;
import org.openapitools.model.GetTwitterAccountFollowersResponseFollowers;
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
  @Transactional
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
  public void deletedeleteAccountInfo(TwitterAccount account) {
    repository.deleteById(account.getId());
  }

  /**
   * フォロワー一覧取得
   * 
   * @param userId ユーザーID
   * @param offset 取得位置
   * @param limit 取得数
   * @return
   * @throws TwitterException
   */
  public ArrayList<GetTwitterAccountFollowersResponseFollowers> getFollowers(
      String userId,
      int offset,
      int limit)
      throws TwitterException {
    // アクセストークンと秘密鍵を取得
    var twitterAccount = repository.findByUserId(userId).get();

    // アクセストークンと秘密鍵をセット
    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthAccessToken(
        new AccessToken(
            twitterAccount.getAccessToken(),
            twitterAccount.getSecretKey()));

    // フォロワーのIDを取得
    var followersIds = twitter.getFollowersIDs(twitter.verifyCredentials().getScreenName(), -1);

    var followers = new ArrayList<GetTwitterAccountFollowersResponseFollowers>();

    if (followersIds.getIDs().length < limit)
      // フォロワーより取得数が多い場合
      limit = followersIds.getIDs().length;

    for (int i = offset; i < limit; i++) {
      long id = followersIds.getIDs()[i];

      // フォロワーの情報を取得
      var follower = twitter.showUser(id);

      var responseFollowerData = new GetTwitterAccountFollowersResponseFollowers();

      responseFollowerData.setId(Long.toString(id));
      responseFollowerData.setScreenName(follower.getScreenName());
      responseFollowerData.setAccountUrl("https://twitter.com/" + follower.getScreenName());

      followers.add(responseFollowerData);
    }

    return followers;
  }

  /**
   * DMを送信
   * 
   * @param twitterAccount
   * @param message
   * @param sendIds
   * @throws TwitterException
   */
  public void postDm(TwitterAccount twitterAccount, String message, long[] sendIds) throws TwitterException {
    // アクセストークンと秘密鍵をセット
    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthAccessToken(
        new AccessToken(
            twitterAccount.getAccessToken(),
            twitterAccount.getSecretKey()));

    for (long sendId : sendIds) {
      twitter.sendDirectMessage(sendId, message);
    }
  }
}
