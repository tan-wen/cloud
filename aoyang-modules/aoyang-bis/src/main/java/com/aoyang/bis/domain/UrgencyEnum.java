package com.aoyang.bis.entity;

public enum UrgencyEnum {

    /**
     * 一般，紧急，非常紧急
     */
    NORMAL("0"), URGENT("1"),VERYURGENT("2");

    private String code;

    private UrgencyEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
