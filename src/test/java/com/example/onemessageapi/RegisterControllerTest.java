package com.example.onemessageapi;

import com.example.onemessageapi.controller.RegisterController;
import com.example.onemessageapi.model.request.CreateMeRequest;
import com.example.onemessageapi.service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RegisterService registerService;

  @BeforeEach
  void setup() {}

  @Test
  void ユーザー登録の検証() throws Exception {

    // リクエストボディ
    var request = new CreateMeRequest();
    request.setName("テスト太郎");
    request.setEmail("a@a.com");
    request.setPassword("aiueo70000");

    mockMvc.perform(post("/api/v1/register")
        .content(new ObjectMapper().writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated());
  }
}
