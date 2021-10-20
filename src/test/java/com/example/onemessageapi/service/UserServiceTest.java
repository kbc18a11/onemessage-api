package com.example.onemessageapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import com.example.onemessageapi.model.entitys.User;
import com.example.onemessageapi.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository repository;

  @Test
  public void ログインユーザーの取得() {

    // ユーザー情報
    var user = new User();
    var userId = "550e8400-e29b-41d4-a716-446655440000";
    user.setId(userId);
    user.setName("山田太郎");
    user.setPassword("password");
    user.setPassword("password");
    user.setEmail("example@example.com");
    user.setAccountNonLocked(false);

    when(repository.findById(userId)).thenReturn(Optional.ofNullable(user));

    var loginUser = userService.getLoginUser(userId);

    assertEquals(loginUser, user);
  }
}
