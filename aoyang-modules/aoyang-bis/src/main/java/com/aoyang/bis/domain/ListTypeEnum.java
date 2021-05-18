package com.aoyang.bis.entity;

public enum ListTypeEnum {

    /**
     *我提出的，我负责的
     */
    PROPOSE("0"),INCHARGE("1");


    private String code;

    private ListTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
