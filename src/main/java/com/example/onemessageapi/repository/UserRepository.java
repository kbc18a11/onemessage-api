package com.example.onemessageapi.repository;

import java.util.List;

import com.example.onemessageapi.entitys.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  /**
   * 引数のメールアドレスから検索 
   * 
   * @param email
   * @return
   */
  List<User> findByEmail(String email);
}
