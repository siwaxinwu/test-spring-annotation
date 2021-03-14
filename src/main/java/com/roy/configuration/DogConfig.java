package com.roy.configuration;

import com.roy.beans.Cook;
import com.roy.beans.Dog;
import com.roy.utils.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** description： author：dingyawu date：created in 20:30 2020/12/6 history: */
@Configuration
@Import(MyBeanPostProcessor.class)
public class DogConfig {

  @Bean(initMethod = "init")
  public Dog dog() {
    return new Dog();
  }

  @Bean
  public Cook cook() {
    return new Cook();
  }
}
