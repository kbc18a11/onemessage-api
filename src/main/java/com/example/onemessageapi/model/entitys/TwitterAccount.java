package com.example.onemessageapi.model.entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "twitterAccounts")
public class TwitterAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // usersテーブルに対する外部キー
  @OneToOne
  @JoinColumn(nullable = false)
  private User user;

  // アクセストークン
  @Column(length = 255, unique = true, nullable = false)
  private String accessToken;

  // 秘密鍵
  @Column(length = 255, unique = true, nullable = false)
  private String secretKey;

  // 作成日時
  @Column(nullable = false)
  private Date createAt;

  // 更新日時
  @Column(nullable = false)
  private Date updateAt;

  /**
   * insert前に実行
   */
  @PrePersist
  public void onPrePersist() {
    this.createAt = new Date();
    this.updateAt = new Date();
  }

  /**
   * update前に実行
   */
  @PreUpdate
  public void onPreUpdate() {
    this.updateAt = new Date();
  }
}
