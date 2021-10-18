package com.example.onemessageapi.service;

import com.example.onemessageapi.config.security.LoginUser;
import com.example.onemessageapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

  private UserRepository repository;

  public UserDetailsServiceImp(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * emailでデータベースからユーザーエンティティを検索する
   */
  @Override
  public UserDetails loadUserByUsername(final String email) {
    return repository.findByEmail(email)
        .map(LoginUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("user not found"));
  }
}
