package com.aoyang.bis.domain;

public enum SupportEnum {

    /**
     * 支持，不支持
     */
    SUPPORT("0"), UNSUPPORT("1");

    private String code;

    private SupportEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
