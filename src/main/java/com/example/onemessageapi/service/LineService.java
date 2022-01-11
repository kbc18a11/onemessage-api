package com.example.onemessageapi.service;

import javax.transaction.Transactional;
import com.example.onemessageapi.model.entitys.LineAccount;
import com.example.onemessageapi.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LineService {

  @Autowired
  private LineRepository repository;

  /**
   * アクセストークンと秘密鍵を削除
   * 
   * @param userId
   */
  @Transactional
  public void deleteAccountInfo(LineAccount lineAccount) {
    repository.deleteById(lineAccount.getId());
  }
}
