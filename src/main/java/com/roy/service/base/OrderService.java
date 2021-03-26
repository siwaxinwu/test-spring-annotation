package com.roy.service.base;

import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 21:48 2021-03-23
 */
@Component
public class OrderService extends BaseService {
  public void test() {
    System.out.println(getUserService());
  }
}
