package com.roy.configuration;

import com.roy.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description： 测试基本的容器注入bean
 * author：dingyawu
 * date：created in 23:20 2020/12/4
 * history:
 */
@Configuration
public class PersonConfig {

    /**
     * 这样可以改变bean的名字
     * @return
     */
    @Bean(value = "extName")
    public Person person(){
        return new Person("roy", 18);
    }
}