package com.example.onemessageapi.model;

import lombok.Data;

/**
 * LINE友達ID一覧 https://developers.line.biz/ja/reference/messaging-api/#get-follower-ids
 */
@Data
public class LineFriendIds {
  private String[] userIds;
  private String next;
}
