package com.roy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * description：
 * 利用includeFilters来指定扫描标注了哪些类的时候，需要禁用默认的过滤规则
 * includeFilters属性只注入PersonConfig2和标注了@controller的类
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@ComponentScan(value = "com.roy",
               includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
                useDefaultFilters = false
               )
public class PersonConfig2 {

}
