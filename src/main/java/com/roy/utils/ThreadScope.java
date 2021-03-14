package com.roy.utils;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description：自定义本地线程级别的bean作用域，不同的线程中对应的bean实例是不同的，同一个线程中同名的bean是同一个实例 author：dingyawu
 * date：created in 10:50 2020/12/5 history:
 */
public class ThreadScope implements Scope {

  public static final String THREAD_SCOPE = "thread";

  private ThreadLocal<Map<String, Object>> beanMap =
      new ThreadLocal() {
        @Override
        protected Object initialValue() {
          return new HashMap<>();
        }
      };

  /**
   * 返回当前作用域中name对应的bean对象 name：需要检索的bean的名称
   * objectFactory：如果name对应的bean在当前作用域中没有找到，那么可以调用这个ObjectFactory来创建这个对象
   */
  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    Object bean = beanMap.get().get(name);
    if (Objects.isNull(bean)) {
      bean = objectFactory.getObject();
      beanMap.get().put(name, bean);
    }
    return bean;
  }

  /** 将name对应的bean从当前作用域中移除 */
  @Nullable
  @Override
  public Object remove(String name) {
    return this.beanMap.get().remove(name);
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
    // bean作用域范围结束的时候调用的方法，用于bean清理
    System.out.println(name);
  }

  @Nullable
  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Nullable
  @Override
  public String getConversationId() {
    return Thread.currentThread().getName();
  }
}
