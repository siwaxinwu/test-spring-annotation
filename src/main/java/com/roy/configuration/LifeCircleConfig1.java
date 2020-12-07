package com.roy.configuration;

import com.roy.beans.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description：
 * 测试bean的初始化和销毁方法，销毁方法只有容器关闭的时候执行
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class LifeCircleConfig1 {
    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Teacher teacher(){
        return new Teacher();
    }
}
