package ru.iteco.aspecthomework.externalServiceApplication.service;

import ru.iteco.aspecthomework.externalServiceApplication.model.ExternalInfo;

public interface Process {
    Boolean run(ExternalInfo externalInfo);
}