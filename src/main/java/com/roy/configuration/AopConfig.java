package com.roy.configuration;

import com.roy.aop.MathHandler;
import com.roy.utils.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description：
 * 使用@EnableAspectJAutoProxy注解开启基于注解的AOP模式
 * author：dingyawu
 * date：created in 13:02 2020/12/7
 * history:
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public MathHandler mathHandler(){
        return new MathHandler();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
