package ru.iteco.aspecthomework.externalServiceApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.aspecthomework.externalServiceApplication.model.ExternalInfo;
import ru.iteco.aspecthomework.externalServiceApplication.service.ExternalService;

@Component
@Aspect
@Slf4j
public class CheckRequestAspect {

    @Value("${id-not-process}")
    private Integer id;

    @Around("allMethodMarkCheckRequestAnnotation(externalInfo)")
    public void aroundAllMethodMarkCheckRequestAnnotationAndHaveExternalInfoInArg(ProceedingJoinPoint proceedingJoinPoint,
                                                                                  ExternalInfo externalInfo) throws Throwable {
        log.info("CHECK REQUEST: {} with {}", proceedingJoinPoint.getSignature().toShortString(), externalInfo);
        if (!id.equals(externalInfo.getId())) {
            log.info("ALLOW REQUEST");
            proceedingJoinPoint.proceed();
        }
    }

    @Pointcut("@annotation(ru.iteco.aspecthomework.externalServiceApplication.model.CheckRequest) && args(externalInfo, ..)")
    public void allMethodMarkCheckRequestAnnotation(ExternalInfo externalInfo) {
    }
}
