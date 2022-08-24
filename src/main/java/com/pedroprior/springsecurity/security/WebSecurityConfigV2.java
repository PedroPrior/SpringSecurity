package com.pedroprior.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigV2 {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                // AntMatchers -> Utilizando controle de acesso por roles.
                // .antMatchers(HttpMethod.GET, "/employees/**").hasRole("ADMIN")
                // .antMatchers(HttpMethod.POST, "/employees/").hasRole("ADMIN")
                // .antMatchers(HttpMethod.DELETE, "/employees/").hasRole("ADMIN")
                // .antMatchers(HttpMethod.PUT, "/employees/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();

      return http.build();

    }





    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
