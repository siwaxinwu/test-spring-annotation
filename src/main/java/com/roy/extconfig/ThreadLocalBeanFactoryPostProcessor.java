package com.roy.extconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:11 2021-03-14
 */
@Configuration
public class ThreadLocalBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    System.out.println("execute beanFactory ............");
    beanFactory.registerScope("threadLocalScope", new ThreadLocalScope());
  }
}
