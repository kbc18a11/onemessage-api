package com.example.onemessageapi.model.entitys;

import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  private String id;

  @Column(length = 32)
  private String name;

  @Column(length = 255, unique = true)
  private String email;

  @Column(length = 255)
  private String password;

  private Date createAt;

  private Date updateAt;

  /**
   * insert前に実行
   */
  @PrePersist
  public void onPrePersist() {
    this.createAt = new Date();
  }

  /**
   * update前に実行
   */
  @PreUpdate
  public void onPreUpdate() {
    this.updateAt = new Date();
  }
}
