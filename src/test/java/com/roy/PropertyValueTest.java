package com.roy;

import com.roy.beans.Teacher;
import com.roy.beans.Worker;
import com.roy.configuration.PropertyValueConfig;
import com.roy.configuration.TeacherValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/** description： author：dingyawu date：created in 23:03 2020/12/6 history: */
public class PropertyValueTest {
  /**
   * 测试bean的@value注入 ，注入字符串和表达式 Worker(name=roy, age=18, systemPropertiesName=Windows 10,
   * randomNumber=14.869541521378205, url=URL [http://www.baidu.com])
   */
  @Test
  public void testPropertyValue() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(PropertyValueConfig.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
    System.out.println("================================");
    Worker worker = (Worker) context.getBean("worker");
    System.out.println(worker);
  }

  /** 测试如何引入自定义的properties文件，并且将properties文件注入bean */
  @Test
  public void testTeacherPropertyValue() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(TeacherValueConfig.class);
    Teacher teacher = (Teacher) ac.getBean("teacher");
    System.out.println(teacher);
  }

  /** 通过environment获取属性值 */
  @Test
  public void testPropertyValue03() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(TeacherValueConfig.class);
    Environment environment = context.getEnvironment();
    String nickName = environment.getProperty("teacher.nickName");
    System.out.println(nickName);
  }
}
