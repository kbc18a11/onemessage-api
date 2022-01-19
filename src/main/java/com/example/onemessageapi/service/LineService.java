package com.example.onemessageapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import javax.transaction.Transactional;
import com.example.onemessageapi.model.LineBotInfo;
import com.example.onemessageapi.model.LineFriendIds;
import com.example.onemessageapi.model.entitys.LineAccount;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.LineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
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

  /**
   * 友達IDの一覧を取得
   * 
   * @param channelToken
   * @return
   * @throws IOException
   * @throws InterruptedException
   */
  public LineFriendIds getFriendIds(String channelToken) throws IOException, InterruptedException {
    // 友達ID一覧取得APIにリクエスト
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.line.me/v2/bot/followers/ids"))
        .header("Authorization", "Bearer " + channelToken)
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // レスポンスボディをLineFriendIdsパーシング
    var objectMapper = new ObjectMapper();
    var friendIds = objectMapper.readValue(response.body(), LineFriendIds.class);

    return friendIds;
  }

  /**
   * DMを送信
   * 
   * @param twitterAccount
   * @param message
   * @param sendIds
   * @throws ExecutionException
   * @throws InterruptedException
   * @throws TwitterException
   */
  public void postDm(String channelToken, String message, String[] sendIds) throws InterruptedException, ExecutionException {
    var client = LineMessagingClient
        .builder(channelToken)
        .build();

    for (String sendId : sendIds) {
      // メッセージの送信
      var pushMessage = new PushMessage(sendId, new TextMessage(message));
      client.pushMessage(pushMessage).get();
    }
  }
}
