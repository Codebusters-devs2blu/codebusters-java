package com.codebusters.codebusters.enums;

public enum Family {

	DAD("DAD"), MOTHER("MOTHER"), DAD_AND_MOTHER("DAD_AND_MOTHER"), OTHERS("OTHERS");

	private String description = "";

	Family(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
