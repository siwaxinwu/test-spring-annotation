package com.roy.configuration;

import com.roy.beans.Person;
import com.roy.filter.MyTypeFilter;
import org.springframework.context.annotation.*;

/**
 * description：
 * 测试@scope的作用域
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class PersonConfig4 {

    @Bean("person")
    @Scope(value = "prototype")
    public Person person(){
        return new Person();
    }

}
