package com.roy.service.base;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 21:47 2021-03-23
 */
public class BaseService {

  @Autowired private UserService userService;

  public UserService getUserService() {
    return userService;
  }
}
