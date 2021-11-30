package com.example.onemessageapi.config.security;

import com.example.onemessageapi.model.entitys.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class LoginUser extends org.springframework.security.core.userdetails.User {

  // Userエンティティ
  private com.example.onemessageapi.model.entitys.User user;

  // ロックされているユーザーロール
  private static final List<GrantedAuthority> ROLE_UNLOCKUSER =
      AuthorityUtils.createAuthorityList("ROLE_UNLOCKUSER");

  // アンロックされているユーザーロール
  private static final List<GrantedAuthority> ROLE_UNLOCKEDUSER =
      AuthorityUtils.createAuthorityList("ROLE_UNLOCKEDUSER");


  public LoginUser(User user) {
    super(user.getName(), user.getPassword(), determineRoles(user.isAccountLocked()));
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  private static List<GrantedAuthority> determineRoles(boolean isAdmin) {
    return isAdmin ? ROLE_UNLOCKUSER : ROLE_UNLOCKEDUSER;
  }
}
