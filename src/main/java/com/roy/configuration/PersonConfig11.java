package com.roy.configuration;

import com.roy.beans.User;
import com.roy.utils.MyImportBeanDefinitionRegistrar;
import com.roy.utils.MyImportSelector;
import com.roy.utils.PersonFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description：
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class PersonConfig11 {
    @Bean
    public PersonFactoryBean personFactoryBean(){
        return new PersonFactoryBean();
    }
}
