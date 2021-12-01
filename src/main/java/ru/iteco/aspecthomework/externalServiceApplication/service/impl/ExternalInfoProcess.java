package ru.iteco.aspecthomework.externalServiceApplication.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.aspecthomework.externalServiceApplication.model.CheckRequest;
import ru.iteco.aspecthomework.externalServiceApplication.model.ExternalInfo;
import ru.iteco.aspecthomework.externalServiceApplication.service.Process;

@Component
public class ExternalInfoProcess implements Process {
    @Value("${id-not-process}")
    private Integer idNotProcess;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalInfoProcess.class);

    @Override
    @CheckRequest
    public Boolean run(ExternalInfo externalInfo) {
        if (idNotProcess.equals(externalInfo.getId())) {
            LOGGER.info("ExternalInfoProcess equals idNotProcess");
            return false;
        } else {
            LOGGER.info("ExternalInfoProcess not equals idNotProcess");
            return true;
        }
    }
}