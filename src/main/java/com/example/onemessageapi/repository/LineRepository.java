package com.example.onemessageapi.repository;

import java.util.Optional;
import com.example.onemessageapi.model.entitys.LineAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineAccount, Integer> {

  /**
   * ユーザーIDが一致するデータを検索
   * 
   * @param userId
   */
  Optional<LineAccount> findByUserId(String userId);
}
