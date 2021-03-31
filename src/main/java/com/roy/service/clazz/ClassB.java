package com.roy.service.clazz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:17 2021-03-31
 */
@Component
@Scope(value = SCOPE_PROTOTYPE)
public class ClassB {
  public void printClass() {
    System.out.println("This is Class B: " + this);
  }
}
