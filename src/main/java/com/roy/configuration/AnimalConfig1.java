package com.roy.configuration;

import com.roy.beans.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description：
 * author：dingyawu
 * date：created in 19:59 2020/12/6
 * history:
 */
@Configuration
public class AnimalConfig1 {
    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy1")
    public Animal animal(){
        return new Animal();
    }
}
