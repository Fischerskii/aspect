package ru.iteco.aspecthomework.externalServiceApplication.model;


public class ExternalInfo {
    Integer id;
    String info;

    public ExternalInfo(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "ExternalInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}