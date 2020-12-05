package com.roy.annotation;

import com.roy.utils.SpringStudySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * description： 自定义一个@EnableSpringStudy的注解，引入别的jar的配置类
 * author：dingyawu
 * date：created in 15:35 2020/12/5
 * history:
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(SpringStudySelector.class)
public @interface EnableSpringStudy {
}