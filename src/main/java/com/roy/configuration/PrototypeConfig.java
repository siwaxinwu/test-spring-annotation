package com.roy.configuration;

import com.roy.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:06 2021-03-14
 */
@Configuration
public class PrototypeConfig {
  @Bean
  @Scope("prototype")
  public User user() {
    return new User();
  }
}
