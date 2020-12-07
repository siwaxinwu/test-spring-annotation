package com.roy.configuration;

import com.roy.beans.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * description：
 * author：dingyawu
 * date：created in 23:26 2020/12/6
 * history:
 */
@PropertySource(value = {"classpath:teacher.properties"})
@Configuration
public class TeacherValueConfig {
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }
}