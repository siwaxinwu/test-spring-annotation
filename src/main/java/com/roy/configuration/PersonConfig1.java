package com.roy.configuration;

import com.roy.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * description：
 * @ComponentScan(value = "com.roy")可以加在配置类上
 * 他所扫描的包里面的类一定要有产生bean的注解，类似@controller和@configuration
 * 可以通过excludeFilters属性排除一部分注解
 *
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@ComponentScan(value = "com.roy",
               excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
               )
public class PersonConfig1 {

}
