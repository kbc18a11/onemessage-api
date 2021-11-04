package com.example.onemessageapi.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.onemessageapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Slf4j
public class JwtTokenFilter extends GenericFilterBean {
  private UserRepository userRepository;
  private Algorithm algorithm;

  public JwtTokenFilter(UserRepository userRepository, String secretKey)
      throws IllegalArgumentException, UnsupportedEncodingException {
    Objects.requireNonNull(secretKey, "secret key must be not null");
    this.userRepository = userRepository;

    this.algorithm = Algorithm.HMAC512(secretKey);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    // トークンの存在確認
    String token = resolveToken(request);

    if (token == null) {
      filterChain.doFilter(request, response);
      return;
    }

    try {
      // コントローラーに送るリクエストボディにJWTからデコードしたユーザーIDをセット
      request.setAttribute("userId", authentication(verifyToken(token)));
    } catch (JWTVerificationException e) {
      log.error("verify token error", e);
      SecurityContextHolder.clearContext();
      ((HttpServletResponse) response).sendError(HttpStatus.UNAUTHORIZED.value(),
          HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }
    filterChain.doFilter(request, response);
  }

  /**
   * トークンの存在の検証
   * 
   * @param request
   * @return
   */
  private String resolveToken(ServletRequest request) {
    String token = ((HttpServletRequest) request).getHeader("Authorization");
    if (token == null || !token.startsWith("Bearer ")) {
      return null;
    }
    // remove "Bearer "
    return token.substring(7);
  }

  /**
   * トークンのデコード
   * 
   * @param token
   * @return
   */
  private DecodedJWT verifyToken(String token) {
    JWTVerifier verifier = JWT.require(algorithm).build();
    return verifier.verify(token);
  }

  /**
   * トークンの解析
   * 
   * @param jwt
   */
  private String authentication(DecodedJWT jwt) {
    String userId = jwt.getSubject();
    userRepository.findById(userId).ifPresent(user -> {
      LoginUser LoginUser = new LoginUser(user);
      SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
          LoginUser, null, LoginUser.getAuthorities()));
    });

    return userId;
  }
}
