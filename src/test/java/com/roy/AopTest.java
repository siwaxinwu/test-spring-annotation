package com.roy;

import com.roy.aop.MathHandler;
import com.roy.configuration.AopConfig;
import com.roy.extconfig.ThreadLocalBeanFactoryPostProcessor;
import com.roy.extconfig.ThreadPoolConfig;
import com.roy.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/** description： author：dingyawu date：created in 13:04 2020/12/7 history: */
public class AopTest {

  /** AOP环境测试 */
  @Test
  public void testAop() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AopConfig.class);
    MathHandler mathHandler = context.getBean(MathHandler.class);
    mathHandler.add(1, 2);
    context.close();
  }

  @Test
  public void testScope() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ThreadLocalBeanFactoryPostProcessor.class);
    ThreadLocalBeanFactoryPostProcessor bean =
        context.getBean(ThreadLocalBeanFactoryPostProcessor.class);
    String[] beanNamesForType =
        context.getBeanNamesForType(ThreadLocalBeanFactoryPostProcessor.class);
    System.out.println(Arrays.toString(beanNamesForType));
  }

  @Test
  public void testASsync() throws InterruptedException {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ThreadPoolConfig.class);
    PersonService personService = context.getBean(PersonService.class);
    for (int i = 0; i < 10; i++) {
      personService.getData();
    }
    Thread.sleep(1000);
  }
}
