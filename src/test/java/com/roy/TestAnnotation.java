package com.roy;

import com.roy.beans.Person;
import com.roy.beans.StudentBean;
import com.roy.beans.Teacher;
import com.roy.configuration.*;
import com.roy.utils.ThreadScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/** description： author：dingyawu date：created in 23:17 2020/12/4 history: */
public class TestAnnotation {

  /** 简单的获取一个配置类的注册bean 这种方式如果配置多个类型的Person的时候，就会报错 */
  @Test
  public void testAnnotationConfig() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    Person person = context.getBean(Person.class);
    System.out.println(person);
  }

  /** 测试如何获取对应的bean名称 */
  @Test
  public void testBeanNamesForType() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
    // 按照类型找到对应的bean名称数组
    String[] names = context.getBeanNamesForType(Person.class);
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 测试@componentScan注解的excludeFilter属性 */
  @Test
  public void testComponentScanByAnnotation() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig1.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 测试@componentScan注解的includeFilter属性 */
  @Test
  public void testComponentScanIncludeFilter() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 测试自定义的MytypeFilter，可以制定注入规则，但是配置类本身肯定是会注入的，不受规则制约 */
  @Test
  public void testComponentScanCustomIncludeFilter() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig3.class);
    String[] names = context.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 测试bean的scope作用域 */
  @Test
  public void testScope() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig4.class);
    Object person1 = ac.getBean("person");
    Object person2 = ac.getBean("person");
    System.out.println("看看两个Person对象是否同一个栈引用：" + person1 == person2);
    System.out.println("看看两个Person对象是否相等：" + person1.equals(person2));
  }

  /** 测试自己写的scope作用域，作用于每个独立的线程 */
  @Test
  public void testAnnotationConfig4() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(PersonConfig5.class);
    // 向容器中注册自定义的scope
    ac.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

    // 使用容器获取bean
    for (int i = 0; i < 2; i++) {
      new Thread(
              () -> {
                System.out.println(Thread.currentThread() + "," + ac.getBean("person"));
                System.out.println(Thread.currentThread() + "," + ac.getBean("person"));
              })
          .start();
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /** 测试@lazy懒加载的使用 */
  @Test
  public void testlazy() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig6.class);
    Object person = ac.getBean("person");
    System.out.println(person);
  }

  /** 测试bean的有条件注入 @conditional注解的使用 */
  @Test
  public void testCondition() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig7.class);
    Environment environment = ac.getEnvironment();
    String osName = environment.getProperty("os.name");
    System.out.println(osName);

    String[] names = ac.getBeanNamesForType(Person.class);
    Arrays.stream(names).forEach(System.out::println);

    Map<String, Person> beans = ac.getBeansOfType(Person.class);
    System.out.println(beans);
  }

  /** 测试@import的用法 */
  @Test
  public void testImport() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig8.class);
    String[] names = ac.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 测试MyImportSelectord的用法，可以一次性注入好多bean */
  @Test
  public void testMyImportSelector() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig9.class);
    String[] names = ac.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /** 自定义一个@EnableSpringStudy注解，可以导入别的jar包的配置类 */
  @Test
  public void testEnableSpringStudy() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(OtherJarConfiguration.class);
    StudentBean studentBean = applicationContext.getBean(StudentBean.class);
    System.out.println(studentBean.getName());
  }

  /** 测试@import中MyImportBeanDefinitionRegistrar的用法 */
  @Test
  public void testMyImportBeanDefinitionRegistrar() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(PersonConfig10.class);
    String[] names = ac.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);
  }

  /**
   * 测试PersonFactoryBean这个实例 personFactoryBean实例的类型为：class com.roy.beans.Person,
   * 演示如何在Spring容器中获取到FactoryBean对象
   */
  @Test
  public void testPersonFactoryBean() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig11.class);
    String[] names = ac.getBeanDefinitionNames();
    Arrays.stream(names).forEach(System.out::println);

    Object personFactoryBean = ac.getBean("personFactoryBean");
    System.out.println("personFactoryBean实例的类型为：" + personFactoryBean.getClass());

    Object personFactoryBean3 = ac.getBean("&personFactoryBean");
    System.out.println("personFactoryBean3类型：" + personFactoryBean3.getClass());
  }

  /** 测试bean的初始化和销毁方法 */
  @Test
  public void testBeanLifeCircle() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(LifeCircleConfig.class);
    Teacher teacher = ac.getBean(Teacher.class);
    Teacher teacher1 = ac.getBean(Teacher.class);
    System.out.println("容器创建完成...");
    ac.close();
  }

  /** 测试多实例bean的初始化和销毁方法 */
  @Test
  public void testBeanLifeCircle1() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(LifeCircleConfig1.class);
    System.out.println("容器创建完成...");
    ac.getBean("teacher");
    ac.getBean("teacher");
    ac.close();
  }

  /** 测试InitializingBean, DisposableBean两个接口 注意执行顺序 */
  @Test
  public void testAnimalConfig() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(AnimalConfig.class);
    System.out.println("IOC容器创建完成...");
    // 关闭IOC容器
    ac.close();
  }

  /** 测试InitializingBean, DisposableBean两个接口,bean实例是多例的情况 销毁方法在多例的情况一个也不调用 */
  @Test
  public void testAnimalConfig1() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(AnimalConfig1.class);
    System.out.println("IOC容器创建完成...");
    // 调用时创建对象
    Object bean = ac.getBean("animal");
    System.out.println("-------");
    // 调用时创建对象
    Object bean1 = ac.getBean("animal");
    System.out.println("-------");
    // 关闭IOC容器
    ac.close();
  }

  /** 测试@PostConstruct和@preDestroy方法 */
  @Test
  public void testCatConfig() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CatConfig.class);
    // 关闭IOC容器
    ac.close();
  }

  /** 测试MyBeanPostProcessor的用法，每个bean初始化前后都会执行一遍两个方法，包括配置类本身的实例化 后置处理器的实现类会在每个bean的初始化前后都会调用 */
  @Test
  public void testDogConfig() {
    // 创建IOC容器
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DogConfig.class);
    // 关闭IOC容器
    ac.close();
  }
}
