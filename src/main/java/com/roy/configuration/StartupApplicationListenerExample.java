package com.roy.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 8:04 2021-03-26
 */
public class StartupApplicationListenerExample
    implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    System.out.println("Subject ContextRefreshedEvent");
  }
}
