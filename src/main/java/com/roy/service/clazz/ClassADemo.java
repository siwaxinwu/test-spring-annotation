package com.roy.service.clazz;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 可以发现简洁了很多，而且不再和Spring强耦合，再次运行测试依然可以得到正确的输出。
 * 被标注的方法的返回值不再重要，因为容器会动态生成一个子类然后将这个被注解的方法重写/实现，最终调用的是子类的方法。 我们也可以使用抽象方法来实现该功能
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 7:16 2021-03-31
 */
@Component
public class ClassADemo {
  public void printClass() {
    System.out.println("This is Class A: " + this);
    getClassB().printClass();
  }

  @Lookup
  public ClassB getClassB() {
    return null;
  }
}
