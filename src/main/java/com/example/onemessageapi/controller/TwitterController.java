package com.example.onemessageapi.controller;

import java.util.Optional;
import javax.validation.Valid;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.service.TwitterService;
import com.example.onemessageapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;
import twitter4j.TwitterException;
import org.openapitools.api.TwitterApi;
import org.openapitools.model.CreateTwitterAccessTokenRequest;
import org.openapitools.model.GetTwitterAccountFollowersResponse;
import org.openapitools.model.GetTwitterAccountResponse;

@RestController
public class TwitterController implements TwitterApi {

  @Autowired
  private final NativeWebRequest request;

  @Autowired
  private UserService userService;

  @Autowired
  private TwitterService twitterService;

  public TwitterController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  /**
   * アクセストークンと秘密鍵を保存
   */
  @Override
  public ResponseEntity<Void> createTwitterAccessToken(
      @Valid CreateTwitterAccessTokenRequest createTwitterAccessTokenRequest) {
    // IDの取得
    var userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();

    try {
      // ユーザー情報を取得
      var user = userService.getLoginUser(userId);

      var twitterAccount = new TwitterAccount();
      twitterAccount.setAccessToken(createTwitterAccessTokenRequest.getAccessToken());
      twitterAccount.setSecretKey(createTwitterAccessTokenRequest.getSecretKey());
      twitterAccount.setUser(user);

      // アクセストークンと秘密鍵を保存
      twitterService.saveAccountTokenAndSecretKey(twitterAccount);

      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * Twitterアカウント情報を取得
   */
  @Override
  public ResponseEntity<GetTwitterAccountResponse> getTwitterAccount() {
    // IDの取得
    var userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();

    try {
      var twitterUser = twitterService.getAccountFindByUserId(userId);

      var response = new GetTwitterAccountResponse();
      response.setAccountUrl("https://twitter.com/" + twitterUser.getScreenName());
      response.setProfileImageURL(twitterUser.get400x400ProfileImageURL());
      response.setScreenName(twitterUser.getScreenName());

      return new ResponseEntity<GetTwitterAccountResponse>(response, HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  /**
   * フォロワー情報の取得
   */
  @Override
  public ResponseEntity<GetTwitterAccountFollowersResponse> getTwitterAccountFollowers(
      @Valid Integer offset, @Valid Integer limit) {
    // IDの取得
    var userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();

    try {
      var followers = twitterService.getFollowers(userId, offset, limit);

      var response = new GetTwitterAccountFollowersResponse();
      response.setTotal(followers.size());
      response.setFollowers(followers);

      return new ResponseEntity<GetTwitterAccountFollowersResponse>(response, HttpStatus.OK);
    } catch (TwitterException e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * アクセストークンと秘密鍵を削除
   */
  @Override
  public ResponseEntity<Void> deleteTwitterAccessToken() {
    // ユーザー情報の取得
    var user = userService
        .getLoginUser(getRequest().map(request -> (String) request.getAttribute("userId", 0)).get());

    try {
      var account = user.getTwitterAccounts();

      // 子であるtwitterアカウント情報を削除するため、nullを代入
      user.setTwitterAccounts(null);

      twitterService.deletedeleteAccountInfo(account);

      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
