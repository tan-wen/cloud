package com.aoyang.bis.entity;

public enum ImportanceEnum {

    /**
     *一般，重要，非常重要
     */
    NORMAL("0"),IMPORTANT("1"),VERYIMPORTANT("2");


    private String code;

    private ImportanceEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
