package com.example.onemessageapi.config.security;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import com.example.onemessageapi.repository.UserRepository;
import com.example.onemessageapi.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.GenericFilterBean;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserRepository userRepository;

  @Value("${security.secret-key:secret}")
  private String secretKey = "secret";

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .cors()
        .and()
        .authorizeRequests()
        .antMatchers("/register").permitAll()
        .mvcMatchers("/user/**").hasRole("UNLOCKEDUSER")
        .mvcMatchers("/me").hasRole("UNLOCKEDUSER")
        .mvcMatchers("/twitter/**").hasRole("UNLOCKEDUSER")
        .mvcMatchers("/line/**").hasRole("UNLOCKEDUSER")
        .mvcMatchers("/dm").hasRole("UNLOCKEDUSER")
        .and()
        // EXCEPTION
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint())
        .accessDeniedHandler(accessDeniedHandler())
        .and()
        // LOGIN
        .formLogin()
        .loginProcessingUrl("/login").permitAll()
        .usernameParameter("email")
        .passwordParameter("password")
        .successHandler(authenticationSuccessHandler())
        .failureHandler(authenticationFailureHandler())
        .and()
        // ★2 LOGOUT
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessHandler(logoutSuccessHandler())
        .and()
        // AUTHORIZE
        .addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class)
        // Basic認証を使わない
        .httpBasic().disable()
        // CSRF対策を無効に設定
        .csrf().disable()
        // セッションはStatelessなので使わない
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  /*
   * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration configuration = new CorsConfiguration(); configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
   * UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**", configuration); return source; }
   */

  /**
   * 認証が必要なリソースに未認証でアクセスしたときの処理
   * 
   * @return
   */
  AuthenticationEntryPoint authenticationEntryPoint() {
    return new JwtAuthenticationEntryPoint();
  }

  @Bean("userDetailsServiceImp")
  UserDetailsService userDetailsServiceImp() {
    return new UserDetailsServiceImp(userRepository);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  GenericFilterBean tokenFilter() throws IllegalArgumentException, UnsupportedEncodingException {
    return new JwtTokenFilter(userRepository, secretKey);
  }

  /**
   * アクセスするリソースの認可に失敗した時の処理
   * 
   * @return
   */
  AccessDeniedHandler accessDeniedHandler() {
    return new JwtAccessDeniedHandler();
  }

  /**
   * 認証に成功した場合
   * 
   * @return
   */
  AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new JwtAuthenticationSuccessHandler(this.secretKey);
  }

  /**
   * 認証に失敗した場合
   * 
   * @return
   */
  AuthenticationFailureHandler authenticationFailureHandler() {
    return new JwtAuthenticationFailureHandler();
  }

  LogoutSuccessHandler logoutSuccessHandler() {
    return new HttpStatusReturningLogoutSuccessHandler();
  }
}
