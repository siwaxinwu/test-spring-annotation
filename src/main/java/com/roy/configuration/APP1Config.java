package com.roy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 测试@lookup注解
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 7:15 2021-03-31
 */
@Configuration
@ComponentScan("com.roy.service.clazz")
public class APP1Config {}
