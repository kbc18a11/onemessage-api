package com.example.onemessageapi.config.security;

import com.example.onemessageapi.model.entitys.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class LoginUser extends org.springframework.security.core.userdetails.User {

  // Userエンティティ
  private com.example.onemessageapi.model.entitys.User user;

  private static final List<GrantedAuthority> unLockedUsers =
      AuthorityUtils.createAuthorityList("unLockedUsers");
  private static final List<GrantedAuthority> lockedUsers =
      AuthorityUtils.createAuthorityList("lockedUsers");

  public LoginUser(User user) {
    super(user.getName(), user.getPassword(), determineRoles(user.isAccountNonLocked()));
    this.user = user;

  }

  public User getUser() {
    return user;
  }

  private static List<GrantedAuthority> determineRoles(boolean isAdmin) {
    return isAdmin ? lockedUsers : unLockedUsers;
  }
}
