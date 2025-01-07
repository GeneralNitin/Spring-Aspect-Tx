package com.generalnitin.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Configurable
@Component
public class LogAspect {

    @Around("@annotation(CustomAnnotation)")
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
