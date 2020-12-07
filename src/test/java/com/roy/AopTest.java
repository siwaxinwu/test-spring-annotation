package com.roy;

import com.roy.aop.MathHandler;
import com.roy.configuration.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description：
 * author：dingyawu
 * date：created in 13:04 2020/12/7
 * history:
 */
public class AopTest {

    /**
     * AOP环境测试
     */
    @Test
    public void testAop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        MathHandler mathHandler = context.getBean(MathHandler.class);
        mathHandler.add(1, 2);
        context.close();
    }
}
