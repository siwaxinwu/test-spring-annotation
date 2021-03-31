package com.roy;

import com.roy.beans.Blue;
import com.roy.beans.Pig;
import com.roy.configuration.*;
import com.roy.dao.TeacherDao;
import com.roy.service.TeacherService;
import com.roy.service.clazz.ClassA;
import com.roy.service.clazz.ClassB;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** description： 测试@autowired注解的使用 author：dingyawu date：created in 9:12 2020/12/7 history: */
public class AutowiredTest {
  /** 测试通过@autowired和@service注入的对象是不是同一个 */
  @Test
  public void testAutowired01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(AutowiredConfig.class);
    TeacherService teacherService = ac.getBean(TeacherService.class);
    System.out.println(teacherService);

    TeacherDao teacherdao = (TeacherDao) ac.getBean("teacherDao");
    System.out.println(teacherdao);
    ac.close();
  }

  /** @autowired测试有多个类型匹配的时候如何指定具体的拿一个对象来匹配 通过对象的引用名 通过@Qaulified注解 */
  @Test
  public void testAutowiredType() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(AutowiredConfig1.class);
    TeacherService teacherService = ac.getBean(TeacherService.class);
    System.out.println(teacherService);
    ac.close();
  }

  /** 测试setter方法上的@autowired注解 */
  @Test
  public void testSetterAutowired() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(AutowiredConfig2.class);
    Pig pig = ac.getBean(Pig.class);
    System.out.println(pig.toString());
    ac.close();
  }

  /** 测试ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware接口的用法 */
  @Test
  public void testBlueAware() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(BlueConfig.class);
    Blue blue = ac.getBean(Blue.class);
    ac.close();
  }

  /** 测试自动注入的bean是原型的，@lookup注解的使用 */
  @Test
  public void testLookup() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(APP1Config.class);
    ClassA classA = ac.getBean(ClassA.class);
    System.out.println(classA);
    classA.printClass();
    classA.printClass();
    classA.printClass();
    classA.printClass();

    ClassB classB = ac.getBean(ClassB.class);
    System.out.println(classB);
    System.out.println(ac.getBean(ClassB.class));
  }

  /** bean工厂的后置处理器 */
  @Test
  public void testBeanPostProcessor() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(APP2Config.class);
  }
}
