package com.aoyang.bis.entity;

public enum StatusEnum {
	/*
	* UNPROCESSED未处理
	* CLAIMED已认领
	* ASSIGNED已指派
	* ACCEPTED已接受
	* ONGOING进行中
	* FINISHED已完成
	* CANCELLED已取消
	* */

	UNPROCESSED("0"),CLAIMED("1"),ASSIGNED("2"),ACCEPTED("3"),ONGOING("4"),
	FINISHED("5"),CANCELLED("6");

	private String code;

	private StatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}