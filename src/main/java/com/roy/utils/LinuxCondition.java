package com.roy.utils;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * description：
 * author：dingyawu
 * date：created in 13:47 2020/12/5
 * history:
 */
public class LinuxCondition implements Condition {
    /**
     * ConditionContext：判断条件使用的上下文环境
     * AnnotatedTypeMetadata：注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断是否是Linux系统
        //1.获取到IOC容器使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前的环境信息
        Environment environment = context.getEnvironment();
        //4.获取bean定义的注册类，我们可以通过BeanDefinitionRegistry对象查看
        //Spring容器中注册了哪些bean，也可以通过BeanDefinitionRegistry对象向
        //Spring容器中注册bean，移除bean，查看bean的定义，查看是否包含某个bean的定义
        BeanDefinitionRegistry registry = context.getRegistry();
        String property = environment.getProperty("os.name");
        return property.contains("linux");
    }
}
