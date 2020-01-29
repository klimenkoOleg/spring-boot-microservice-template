package com.oklimenko.sampleapp.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Logs all entry and exit parameters (if DEBUG level is enabled).
 * Useful for Controllers and Services.
 *
 * @author oklimenko@gmail.com
 */
@Aspect
@Component
@Slf4j
public class LogMethodStartExitAspect {

    @Pointcut("within(@LogMethodStartExit *)")
    public void beanAnnotatedLogMethodStartExit() {
    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Pointcut("publicMethod() && beanAnnotatedLogMethodStartExit()")
    public void publicMethodInsideAClassMarkedWithLogMethodStartExit() {
    }

    @Around("publicMethodInsideAClassMarkedWithLogMethodStartExit()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint.getSignature() != null) {
            log.debug("<<<<<    BEFORE!!! " +
                    joinPoint.getSignature().getDeclaringTypeName() + // class
                    "." + joinPoint.getSignature().getName() + // method
                    ": [" + Arrays.toString(joinPoint.getArgs()) + "]"
            );
        }

        Object result = joinPoint.proceed();

        if (joinPoint.getSignature() != null) {
            log.debug(">>>>>    AFTER!!! " +
                    joinPoint.getSignature().getDeclaringTypeName() + // class
                    "." + joinPoint.getSignature().getName() + // method
                    ": [" + result + "]");
        }
        return result;
    }
}
