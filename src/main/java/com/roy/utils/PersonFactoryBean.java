package com.roy.utils;

import com.roy.beans.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * description：
 * 利用PersonFactoryBean注入一个实例
 * author：dingyawu
 * date：created in 22:40 2020/12/5
 * history:
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    //返回一个Person对象，这个对象会被注册到Spring容器中
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    //bean是否为单例;true:是；false:否
    @Override
    public boolean isSingleton() {
        return true;
    }
}