package com.aoyang.wx.work.model;

public enum FlagEnum {
    /**
     * 成功，失败
     */
    SUCCESS("success"), FAIL("fail");

    private String code;

    private FlagEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
