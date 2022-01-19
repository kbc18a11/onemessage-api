package com.example.onemessageapi.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) throws IOException {
    if (response.isCommitted()) {
      return;
    }

    dump(exception);
    response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
  }

  private void dump(AuthenticationException e) {
    if (e instanceof BadCredentialsException) {
      log.debug("BadCredentialsException : {}", e.getMessage());
    } else if (e instanceof LockedException) {
      log.debug("LockedException : {}", e.getMessage());
    } else if (e instanceof DisabledException) {
      log.debug("DisabledException : {}", e.getMessage());
    } else if (e instanceof AccountExpiredException) {
      log.debug("AccountExpiredException : {}", e.getMessage());
    } else if (e instanceof CredentialsExpiredException) {
      log.debug("CredentialsExpiredException : {}", e.getMessage());
    } else if (e instanceof SessionAuthenticationException) {
      log.debug("SessionAuthenticationException : {}", e.getMessage());
    } else {
      log.debug("AuthenticationException : {}", e.getMessage());
    }
  }
}
