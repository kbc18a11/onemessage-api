package com.example.onemessageapi.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException exception) throws IOException {
    if (response.isCommitted()) {
      return;
    }
    dump(exception);
    response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
  }

  private void dump(AccessDeniedException e) {
    if (e instanceof AuthorizationServiceException) {
      log.debug("AuthorizationServiceException : {}", e.getMessage());
    } else if (e instanceof CsrfException) {
      log.debug("org.springframework.security.web.csrf.CsrfException : {}", e.getMessage());
    } else if (e instanceof org.springframework.security.web.server.csrf.CsrfException) {
      log.debug("org.springframework.security.web.server.csrf.CsrfException : {}", e.getMessage());
    } else {
      log.debug("AccessDeniedException : {}", e.getMessage());
    }
  }
}
