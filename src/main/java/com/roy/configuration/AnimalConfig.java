package com.roy.configuration;

import com.roy.beans.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：
 * author：dingyawu
 * date：created in 19:59 2020/12/6
 * history:
 */
@Configuration
public class AnimalConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy1")
    public Animal animal(){
        return new Animal();
    }
}
