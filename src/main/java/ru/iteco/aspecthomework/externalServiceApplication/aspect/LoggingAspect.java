package ru.iteco.aspecthomework.externalServiceApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("allMethodInService()")
    public void beforeAllMethodInServiceAdvice(JoinPoint joinPoint) {
        log.info("beforeAllMethodInServiceAdvice:: START {}", joinPoint.getSignature().toShortString());
    }

    @Before("allMethodInService()")
    public void afterAllMethodInServiceAdvice(JoinPoint joinPoint) {
        log.info("afterAllMethodInServiceAdvice:: END {}", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(value = "allMethodInService()", throwing = "exception")
    public void afterAllMethodInServiceThrowAdvice(JoinPoint joinPoint, Exception exception) {
        log.info("afterAllMethodInServiceThrowAdvice:: END {} WITH THROW: {}", joinPoint.getSignature().toShortString(), exception.toString());
    }

    @Pointcut("within(ru.iteco.aspecthomework.externalServiceApplication.service.*)")
    public void allMethodInService() {};
}
