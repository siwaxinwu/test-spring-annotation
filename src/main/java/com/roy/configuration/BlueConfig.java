package com.roy.configuration;

import com.roy.beans.Blue;
import com.roy.utils.PersonFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description：
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class BlueConfig {
    @Bean
    public Blue blue(){
        return new Blue();
    }
}
