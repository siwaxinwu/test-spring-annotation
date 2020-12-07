package com.roy.configuration;

import com.roy.beans.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：
 * author：dingyawu
 * date：created in 20:30 2020/12/6
 * history:
 */
@Configuration
public class CatConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }
}
