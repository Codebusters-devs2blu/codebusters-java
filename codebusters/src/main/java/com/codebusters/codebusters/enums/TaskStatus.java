package com.codebusters.codebusters.enums;

public enum TaskStatus {

	COMPLETE("COMPLETE"), PENDING("PENDING"), NOT_COMPLETE("NOT_COMPLETE"), PAID("PAID");

	private String description = "";

	TaskStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
