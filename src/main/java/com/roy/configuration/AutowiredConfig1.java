package com.roy.configuration;

import com.roy.dao.TeacherDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * description：
 * author：dingyawu
 * date：created in 9:10 2020/12/7
 * history:
 */
@Configuration
@ComponentScan(value = {
        "com.roy.dao",
        "com.roy.service",
        "com.roy.controller"})
public class AutowiredConfig1 {


    @Bean("teacherDao2")
    @Primary
    public TeacherDao personDao(){
        return new TeacherDao("2");
    }
}