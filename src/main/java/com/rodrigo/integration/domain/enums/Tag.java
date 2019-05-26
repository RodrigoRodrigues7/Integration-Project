package com.rodrigo.integration.domain.enums;

public enum Tag {

	UNSC("unsc"), 
	COVENANT("covenant"), 
	NO_TAG("no-tag");

	private String name;

	private Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
