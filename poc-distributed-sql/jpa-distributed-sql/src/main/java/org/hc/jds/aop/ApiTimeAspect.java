package org.hc.jds.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ApiTimeAspect {

    @Pointcut("execution(public * org.hc.jds.controller.*.*(..))")
    public void apiPointcut() {}

    @Around("apiPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            long cost = System.currentTimeMillis() - startTime;
            recordCost(joinPoint, cost);
        }
        return result;
    }

    private void recordCost(ProceedingJoinPoint joinPoint, long cost) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        log.info("API耗时统计 || 方法: {} || 耗时: {}ms", methodName, cost);
    }
}

