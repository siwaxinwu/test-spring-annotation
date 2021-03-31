package com.roy.service.clazz;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * 这是其中一种写法 可以使用@lookup来代替
 * @author dingyawu
 * @version 1.0
 * @date created in 7:16 2021-03-31
 */

@Component
public class ClassA implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public void printClass() {
		System.out.println("This is Class A: " + this);
		getClassB().printClass();
	}

	public ClassB getClassB() {
		return applicationContext.getBean(ClassB.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}

