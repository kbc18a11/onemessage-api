package com.example.onemessageapi.model;

import lombok.Data;

/**
 * LINEボット https://developers.line.biz/ja/reference/messaging-api/#get-bot-info-response
 */
@Data
public class LineBotInfo {
  private String userId;

  private String basicId;

  private String displayName;

  private String pictureUrl;

  private String chatMode;

  private String markAsReadMode;
}
