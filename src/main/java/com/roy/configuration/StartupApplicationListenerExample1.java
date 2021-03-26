package com.roy.configuration;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 8:18 2021-03-26
 */
public class StartupApplicationListenerExample1 {

  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("Subject ContextRefreshedEvent");
  }
}
