package com.example.onemessageapi.config.security;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private Algorithm algorithm;

  private static final Long EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(10L);

  public JwtAuthenticationSuccessHandler(String secretKey) {
    Objects.requireNonNull(secretKey, "secret key must be not null");

    try {
      this.algorithm = Algorithm.HMAC512(secretKey);
    } catch (IllegalArgumentException e) {
      this.algorithm = null;
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      this.algorithm = null;
      e.printStackTrace();
    }
  }

  /**
   * ログインイベント
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
      HttpServletResponse response,
      Authentication auth) {
    if (response.isCommitted()) {
      return;
    }
    setToken(response, generateToken(auth));
    response.setStatus(HttpStatus.OK.value());
    clearAuthenticationAttributes(request);
  }

  /**
   * トークンの生成
   * 
   * @param auth
   * @return
   */
  private String generateToken(Authentication auth) {
    LoginUser loginUser = (LoginUser) auth.getPrincipal();
    Date issuedAt = new Date();
    Date notBefore = new Date(issuedAt.getTime());
    Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);
    String token = JWT.create()
        .withIssuedAt(issuedAt)
        .withNotBefore(notBefore)
        .withExpiresAt(expiresAt)
        .withSubject(loginUser.getUser().getId().toString())
        .sign(this.algorithm);
    log.debug("generate token : {}", token);
    return token;
  }

  /**
   * トークンをヘッダーにセットする
   * 
   * @param response
   * @param token
   */
  private void setToken(HttpServletResponse response, String token) {
    response.setHeader("Authorization", String.format("Bearer %s", token));
    response.setHeader("Access-Control-Expose-Headers", "Authorization");
  }

  /**
   * Removes temporary authentication-related data which may have been stored in the session during
   * the authentication process.
   */
  private void clearAuthenticationAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }
    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
