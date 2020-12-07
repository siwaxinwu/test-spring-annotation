package com.roy.configuration;

import com.roy.beans.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：
 * author：dingyawu
 * date：created in 23:02 2020/12/6
 * history:
 */
@Configuration
public class PropertyValueConfig {
    @Bean
    public Worker worker(){
        return new Worker();
    }
}