package com.roy.utils;

import com.roy.beans.Person;
import com.roy.beans.StudentBean;
import com.roy.beans.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * description：
 * author：dingyawu
 * date：created in 22:19 2020/12/5
 * history:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata: 当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     * 通过调用BeanDefinitionRegistry接口的registerBeanDefinition()方法，可以将所有需要添加到容器中的bean注入到容器中。
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        boolean user = registry.containsBeanDefinition(User.class.getName());
        boolean person = registry.containsBeanDefinition(Person.class.getName());
        if (user && person){
            BeanDefinition beanDefinition = new RootBeanDefinition(StudentBean.class);
            registry.registerBeanDefinition("studentBean", beanDefinition);
        }
    }
}
