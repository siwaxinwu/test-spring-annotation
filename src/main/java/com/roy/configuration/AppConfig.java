package com.roy.configuration;

import com.roy.beans.StudentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** description： author：dingyawu date：created in 15:36 2020/12/5 history: */
@Configuration
public class AppConfig {
  @Bean
  public StudentBean studentBean() {
    StudentBean studentBean = new StudentBean();
    studentBean.setId(19);
    studentBean.setName("admin");
    return studentBean;
  }
}
