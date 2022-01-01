package com.example.onemessageapi.repository;

import java.util.Optional;
import com.example.onemessageapi.model.entitys.User;

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
  Optional<User> findByEmail(String email);

  /**
   * 引数のメールアドレスからユーザーの存在を確認
   * 
   * @param email
   * @return
   */
  boolean existsByEmail(String email);

  /**
   * 引数のIDからログインユーザーを取得
   * 
   * @param userId
   * @return
   */
  Optional<User> findById(String userId);
}
