package com.roy;

import com.roy.configuration.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 9:58 2021-03-14
 */
public class ProfileTest {
  @Test
  public void testProfile01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ProfileConfig.class);
    String[] names = context.getBeanNamesForType(DataSource.class);
    Stream.of(names).forEach(System.out::println);
  }

  /** 测试如何选择运行的环境 */
  @Test
  public void testProfile02() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.getEnvironment().setActiveProfiles("prod");
    context.register(ProfileConfig.class);
    context.refresh();
    String[] names = context.getBeanNamesForType(DataSource.class);
    Stream.of(names).forEach(System.out::println);
  }
}
