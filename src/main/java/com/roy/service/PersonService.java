package com.roy.service;

import com.roy.extconfig.ThreadPoolConfig;
import org.springframework.scheduling.annotation.Async;

/**
 * 测试@Async,采用线程池
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 16:58 2021-03-14
 */
public class PersonService {
  @Async(ThreadPoolConfig.THREAD_POOL_NAME)
  public void getData() {
    System.out.println("threadname：" + Thread.currentThread().getName());
  }
}
