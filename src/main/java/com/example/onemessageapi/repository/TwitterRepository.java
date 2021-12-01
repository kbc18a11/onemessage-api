package com.example.onemessageapi.repository;

import java.util.List;
import java.util.Optional;
import com.example.onemessageapi.model.entitys.TwitterAccount;
import com.example.onemessageapi.model.entitys.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends JpaRepository<TwitterAccount, Integer> {

  /**
   * ユーザーIDが一致するデータを検索
   * 
   * @param userId
   */
  Optional<TwitterAccount> findByUserId(String userId);

  /**
   * ユーザーIDからデータを削除
   * 
   * @param userId
   */
  void deleteByUserId(String userId);
}
