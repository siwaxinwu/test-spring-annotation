package com.roy.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/** description： author：dingyawu date：created in 11:21 2020/12/7 history: */
@Aspect
public class LogAspect {

  @Pointcut("execution(public int com.roy.aop.MathHandler.*(..))")
  public void pointCut() {}

  @Before("pointCut()")
  public void logStart(JoinPoint joinPoint) {
    System.out.println(
        joinPoint.getSignature().getName()
            + " 运行开始，参数列表是：{"
            + Arrays.asList(joinPoint.getArgs())
            + "}");
  }

  @After("pointCut()")
  public void logEnd(JoinPoint joinPoint) {
    System.out.println(joinPoint.getSignature().getName() + " 运行结束");
  }

  @AfterReturning(value = "pointCut()", returning = "result")
  public void logReturn(JoinPoint joinPoint, Object result) {
    System.out.println(joinPoint.getSignature().getName() + " 正常返回，运行结果：{" + result + "}");
  }

  @AfterThrowing(value = "pointCut()", throwing = "exception")
  public void logException(JoinPoint joinPoint, Exception exception) {
    System.out.println(joinPoint.getSignature().getName() + " 异常，异常信息：{" + exception + "}");
  }
}
