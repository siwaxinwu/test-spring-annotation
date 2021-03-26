package com.roy.extconfig;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:13 2021-03-14
 */
public class ThreadLocalScope implements Scope {

  private static final ThreadLocal THREAD_LOCAL_SCOPE = new ThreadLocal();

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    Object value = THREAD_LOCAL_SCOPE.get();
    if (value != null) {
      return value;
    }

    Object object = objectFactory.getObject();
    THREAD_LOCAL_SCOPE.set(object);
    return object;
  }

  @Override
  public Object remove(String name) {
    THREAD_LOCAL_SCOPE.remove();
    return null;
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {}

  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  public String getConversationId() {
    return null;
  }
}
