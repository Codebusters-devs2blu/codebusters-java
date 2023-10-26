package com.codebusters.codebusters.enums;

public enum ReleaseType {

	IN("IN"), OUT("OUT");

	private String description = "";

	ReleaseType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
