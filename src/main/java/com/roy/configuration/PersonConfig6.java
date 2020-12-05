package com.roy.configuration;

import com.roy.beans.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * description：
 * 一般我们new一个容器的话，就会执行ac init with person bean，只针对单例，对于原型的作用域例外，天生就是懒加载
 * 测试@lazy懒加载的使用
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class PersonConfig6 {
    @Bean
    @Lazy
    public Person person(){
        System.out.println("ac init with person bean");
        return new Person();
    }

}
