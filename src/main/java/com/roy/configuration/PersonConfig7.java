package com.roy.configuration;

import com.roy.beans.Person;
import com.roy.utils.LinuxCondition;
import com.roy.utils.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * description：
 *
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
public class PersonConfig7 {
    @Conditional({WindowsCondition.class})
    @Bean
    public Person person01(){
        return new Person("roy", 18);
    }

    @Conditional({LinuxCondition.class})
    @Bean
    public Person person02(){
        return new Person("tom", 20);
    }

}
