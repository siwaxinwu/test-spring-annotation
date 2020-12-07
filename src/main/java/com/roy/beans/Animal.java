package com.roy.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * description：
 * 测试bean的接口InitializingBean, DisposableBean
 * author：dingyawu
 * date：created in 19:58 2020/12/6
 * history:
 */
public class Animal implements InitializingBean, DisposableBean {
    public Animal(){
        System.out.println("执行了Animal类的无参数构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行了Animal类的初始化方法afterPropertiesSet。。。。。");

    }
    @Override
    public void destroy() throws Exception {
        System.out.println("执行了Animal类的销毁方法。。。。。");

    }
    public void init(){
        System.out.println("execute init method ..........");
    }

    public void destroy1() throws Exception {
        System.out.println("execute destroy1 method .......");

    }


}