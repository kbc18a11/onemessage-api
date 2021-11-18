package com.example.onemessageapi.controller;

import java.util.Optional;
import javax.validation.Valid;
import com.example.onemessageapi.api.TwitterApi;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.model.request.CreateTwitterAccessTokenRequest;
import com.example.onemessageapi.service.TwitterService;
import com.example.onemessageapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

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
    var userId = "";

    try {
      // IDの取得
      userId = getRequest().map(request -> (String) request.getAttribute("userId", 0)).get();
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    try {
      // ユーザー情報を取得
      var user = userService.getLoginUser(userId);

      var twitterAccount = new TwitterAccount();
      twitterAccount.setAccessToken(createTwitterAccessTokenRequest.getAccessToken());
      twitterAccount.setSecretKey(createTwitterAccessTokenRequest.getSecretKey());
      twitterAccount.setUser(user);

      System.out.println(twitterAccount.getAccessToken());

      // アクセストークンと秘密鍵を保存
      twitterService.saveAccountTokenAndSecretKey(twitterAccount);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * Twitterの認可URLを取得する
   */
  /*
   * @Override public ResponseEntity<GetTwitterAuthUrlResponse> getTwitterAuthUrl() { var response =
   * new GetTwitterAuthUrlResponse();
   * 
   * var twitterUserId = "suberumaiku";
   * 
   * try { Query query = new Query("source:twitter4j yusukey"); QueryResult result =
   * twitter.search(query); for (Status status : result.getTweets()) { var user = status.getUser();
   * System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText()); } } catch
   * (TwitterException e) { e.printStackTrace(); System.err.println(e);
   * 
   * throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()); }
   * 
   * return new ResponseEntity<GetTwitterAuthUrlResponse>(response, HttpStatus.OK); }
   */
}
