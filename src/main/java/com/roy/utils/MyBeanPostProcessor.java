package com.roy.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/** description： author：dingyawu date：created in 21:06 2020/12/6 history: */
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println(
        "调用了postProcessBeforeInitialization方法，beanName = " + beanName + ", bean = " + bean);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println(
        "调用了postProcessAfterInitialization，beanName = " + beanName + ", bean = " + bean);
    return bean;
  }

  @Override
  public int getOrder() {
    return 3;
  }
}
