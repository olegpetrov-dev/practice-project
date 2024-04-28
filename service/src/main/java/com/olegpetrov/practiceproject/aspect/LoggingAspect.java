package com.olegpetrov.practiceproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
@ConditionalOnProperty(value = "app.logging.aspect.enabled", havingValue = "true")
public class LoggingAspect {

    @Around("execution(* com.olegpetrov.practiceproject..*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("Entering method: {} with arguments: {}", methodName, Arrays.toString(args));

        Object result = joinPoint.proceed();

        log.info("Exiting method: {} with result: {}", methodName, result);
        return result;
    }
}

