package com.roy;

import com.roy.beans.User;
import com.roy.configuration.PrototypeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** description： author：dingyawu date：created in 13:04 2020/12/7 history: */
public class DesignModeTest {

  /** 演示Spring框架中的原型模式 */
  @Test
  public void testPrototype() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(PrototypeConfig.class);
    User user1 = context.getBean(User.class);
    User user2 = context.getBean(User.class);
    System.out.println(user1 == user2);
  }
}
