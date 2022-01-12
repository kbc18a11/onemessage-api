package com.example.onemessageapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.transaction.Transactional;
import com.example.onemessageapi.model.LineBotInfo;
import com.example.onemessageapi.model.entitys.LineAccount;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.LineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LineService {

  @Autowired
  private LineRepository repository;

  /**
   * LINEBOT情報の取得
   * 
   * @param channelAccessToken
   * @return
   * @throws IOException
   * @throws InterruptedException
   */
  public LineBotInfo getBotInfo(String channelToken) throws IOException, InterruptedException {
    // LINEBOTの情報取得APIにリクエスト
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.line.me/v2/bot/info"))
        .header("Authorization", "Bearer " + channelToken)
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // レスポンスボディをLineBotInfoパーシング
    var objectMapper = new ObjectMapper();
    var lineBotInfo = objectMapper.readValue(response.body(), LineBotInfo.class);

    return lineBotInfo;
  }

  /**
   * LINEBOT情報の登録
   * 
   * @param channelToken
   * @param user
   * @return
   * @throws Exception
   */
  public LineBotInfo createAccountInfo(String channelToken, User user) throws Exception {
    var lineBotInfo = getBotInfo(channelToken);
    if (lineBotInfo == null)
      // BOT情報が存在しない場合
      throw new Exception();

    var lineAccount = new LineAccount();
    lineAccount.setChannelToken(channelToken);
    lineAccount.setUser(user);

    repository.save(lineAccount);

    return lineBotInfo;
  }

  /**
   * LINEBOT情報の削除
   * 
   * @param userId
   */
  @Transactional
  public void deleteAccountInfo(LineAccount lineAccount) {
    repository.deleteById(lineAccount.getId());
  }
}
