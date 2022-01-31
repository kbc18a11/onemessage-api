package com.example.onemessageapi.service;

import java.util.List;
import com.example.onemessageapi.model.entitys.DmHistory;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.DmHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmService {
  @Autowired
  DmHistoryRepository repository;

  /**
   * 送信メッセージ履歴を保存
   * 
   * @param message
   * @param user
   */
  public void createDmHistory(String message, User user) {
    var dmHistory = new DmHistory();
    dmHistory.setMessage(message);
    dmHistory.setUser(user);

    repository.save(dmHistory);
  }

  /**
   * 送信メッセージ履歴一覧の取得
   * 
   * @return
   */
  public List<DmHistory> getHistories() {
    return repository.findAll();
  }
}
