package com.roy.configuration;

import com.roy.filter.MyTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * description：
 * 自定义includeFilter规则
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@ComponentScan(value = "com.roy",
               includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
                useDefaultFilters = false
               )
public class PersonConfig3 {

}
