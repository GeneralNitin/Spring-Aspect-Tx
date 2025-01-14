package com.generalnitin.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LogAspect {

    // Add 'execution(* *(..))' to avoid capturing native AspectJ 'call' pointcuts
    @Around("@annotation(CustomAnnotation) && execution(* *(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CustomAnnotation execTime = method.getAnnotation(CustomAnnotation.class);
        String metricName = execTime.metricName() != null ? execTime.metricName() : "method.timer";

        StopWatch stopWatch = new StopWatch();
        stopWatch.start(metricName);

        try {
            return joinPoint.proceed();
        }
        finally {
            stopWatch.stop();
            System.out.println(stopWatch.lastTaskInfo().getTaskName() +" "+ stopWatch.getTotalTime(TimeUnit.MILLISECONDS));
        }
    }
}
