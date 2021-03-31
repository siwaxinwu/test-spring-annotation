package com.roy.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * bean工厂的后置处理器
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 8:03 2021-03-31
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    // 可以在这一步去创建一个bean
    // Object bean = beanFactory.getBean("");
    BeanDefinition bd = beanFactory.getBeanDefinition("person");
    System.out.println(bd.getClass());
  }
}
