package com.roy.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description：
 * author：dingyawu
 * date：created in 20:29 2020/12/6
 * history:
 */
public class Cat {

    public Cat(){
        System.out.println("Cat类的构造方法...");
    }

    public void init(){
        System.out.println("Cat的init()方法...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Cat的postConstruct()方法...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Cat的preDestroy()方法...");
    }

    public void destroy(){
        System.out.println("Cat的destroy()方法...");
    }
}