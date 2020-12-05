package com.roy.configuration;

import com.roy.beans.Employee;
import com.roy.beans.Person;
import com.roy.beans.User;
import com.roy.utils.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description：
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@Import({User.class, MyImportSelector.class})
public class PersonConfig9 {
}
