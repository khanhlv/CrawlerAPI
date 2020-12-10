package com.crawler.dto.enums;

public enum Web {
    AMAZON_COM("amazon.com", "amazon.com");

    Web(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
