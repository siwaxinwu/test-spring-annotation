package com.roy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
public class AutowiredConfig {}