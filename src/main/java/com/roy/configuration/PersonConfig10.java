package com.roy.configuration;

import com.roy.beans.User;
import com.roy.utils.MyImportBeanDefinitionRegistrar;
import com.roy.utils.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description：
 * 测试MyImportBeanDefinitionRegistrar，注入bean的时候用这种方式带条件注入
 * 个人理解也是mybatis等产品侵入spring的一种方式，是spring容器接入第三方产品的方式
 * author：dingyawu
 * date：created in 23:37 2020/12/4
 * history:
 */
@Configuration
@Import({User.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class PersonConfig10 {
}
