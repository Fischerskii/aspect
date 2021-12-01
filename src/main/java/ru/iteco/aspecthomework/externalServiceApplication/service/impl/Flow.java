package ru.iteco.aspecthomework.externalServiceApplication.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.iteco.aspecthomework.externalServiceApplication.model.ExternalInfo;
import ru.iteco.aspecthomework.externalServiceApplication.service.Process;
import ru.iteco.aspecthomework.externalServiceApplication.service.ExternalService;

@Component
public class Flow {

    private final Process process;
    private final ExternalService externalService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Flow.class);

    public Flow(ExternalService externalService, Process process) {
        this.process = process;
        this.externalService = externalService;
    }

    public void run(Integer id) {
        ExternalInfo externalInfo = externalService.getExternalInfo(id);

        if (externalInfo != null) {
            process.run(externalInfo);
        } else {
            LOGGER.info("Not run process: {}", externalInfo);
        }
    }
}