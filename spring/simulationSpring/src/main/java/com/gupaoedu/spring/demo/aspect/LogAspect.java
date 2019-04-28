package com.gupaoedu.spring.demo.aspect;

import com.gupaoedu.spring.framework.aop.aspect.GPJoinPoint;

import java.util.Arrays;

/**
 * Created by Tom on 2019/4/14.
 */
public class LogAspect {

    public void before(GPJoinPoint joinPoint){
        //往对象里面记录调用的开始时间
        System.out.println("Invoker Before Method!!!" +
                "\nTargetObject:" + joinPoint.getThis() +
                "\nArgs:" + Arrays.toString(joinPoint.getArguments()));
    }

    public void after(GPJoinPoint joinPoint){
        //系统当前时间-之前记录的开始时间=方法的调用所消耗的时间
        //就能够监测出方法执行性能
        System.out.println("Invoker After Method!!!" +
                "\nTargetObject:" + joinPoint.getThis() +
                "\nArgs:" + Arrays.toString(joinPoint.getArguments()));
    }

    public void afterThrowing(GPJoinPoint joinPoint, Throwable ex){
        //异常监测，我可以拿到异常的信息
        System.out.println("出现异常" +
                "\nTargetObject:" + joinPoint.getThis() +
                "\nArgs:" + Arrays.toString(joinPoint.getArguments()) +
                "\nThrows:" + ex.getMessage());
    }

}
