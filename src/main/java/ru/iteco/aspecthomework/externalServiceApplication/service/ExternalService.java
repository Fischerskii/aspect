package ru.iteco.aspecthomework.externalServiceApplication.service;

import ru.iteco.aspecthomework.externalServiceApplication.model.ExternalInfo;

public interface ExternalService {
    ExternalInfo getExternalInfo(Integer id);
}
