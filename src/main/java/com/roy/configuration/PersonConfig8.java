package com.roy.configuration;

import com.roy.beans.Employee;
import com.roy.beans.Person;
import com.roy.utils.LinuxCondition;
import com.roy.utils.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description：
 * 测试@import的用法,同时引入两个bean
 * 直接填class数组方式
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@Import({Person.class, Employee.class})
public class PersonConfig8 {


}
