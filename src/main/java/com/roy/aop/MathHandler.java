package com.roy.aop;

/**
 * description：
 * author：dingyawu
 * date：created in 11:21 2020/12/7
 * history:
 */
public class MathHandler {

    public int add(int i, int j){
        System.out.println("目标方法执行");
        return i + j;
    }
}
