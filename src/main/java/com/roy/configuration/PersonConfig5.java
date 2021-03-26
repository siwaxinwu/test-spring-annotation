package com.roy.configuration;

import com.roy.beans.Person;
import com.roy.extconfig.ThreadLocalScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * description： 自定义本地线程级别的bean作用域，不同的线程中对应的bean实例是不同的，同一个线程中同名的bean是同一个实例
 * ,也可以通过注解实现StartupApplicationListenerExample1author：dingyawu date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@Import(value = {StartupApplicationListenerExample.class, ThreadLocalScope.class})
public class PersonConfig5 {

  /**
   * 演示容器的监听事件 refresh（）的时候调用
   *
   * @return {@link Person}
   */
  @Bean
  @Scope(value = "threadLocalScope")
  public Person person() {
    return new Person();
  }
}
