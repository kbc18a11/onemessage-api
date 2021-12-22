package com.example.onemessageapi.model.entitys;

import java.util.Date;
import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  private String id;

  @Column(length = 32, nullable = false)
  private String name;

  @Column(length = 255, unique = true, nullable = false)
  private String email;

  @Column(length = 255, nullable = false)
  private String password;

  // ユーザアカウントがロックされているかの設定
  @Column(columnDefinition = "boolean default false", nullable = false)
  private boolean accountLocked;

  // usersテーブルに対する外部キー
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private TwitterAccount twitterAccounts;

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
