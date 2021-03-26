package com.roy;

import com.roy.beans.Person;
import com.roy.configuration.ExtendsConfig;
import com.roy.configuration.PersonConfig5;
import com.roy.extconfig.ThreadLocalBeanFactoryPostProcessor;
import com.roy.service.base.OrderService;
import com.roy.service.base.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** description： author：dingyawu date：created in 13:04 2020/12/7 history: */
public class ExtTest {

  /** 可以提取注入点到父类当中, 模板方法经常使用 针对OrderService寻找注入点的时候,会去获取父类的注入点 */
  @Test
  public void testExtendAutowired() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ExtendsConfig.class);
    OrderService orderService = (OrderService) context.getBean("orderService");
    UserService userService = orderService.getUserService();
    System.out.println(userService);
  }

  @Test
  public void testListner() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(
            PersonConfig5.class, ThreadLocalBeanFactoryPostProcessor.class);
    Person person = context.getBean(Person.class);
    System.out.println(person.getAge());
  }
}
