package com.roy.configuration;

import com.roy.beans.Person;
import com.roy.utils.MyBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试factoryBeanPostProcessor
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 7:15 2021-03-31
 */
@Configuration
// @Import(MyBeanFactoryPostProcessor.class)
public class APP2Config {
  @Bean
  public Person person() {
    return new Person();
  }

  @Bean
  public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
    return new MyBeanFactoryPostProcessor();
  }
}
