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
	
	public static Tag toEnum(String name) {

		if (name == null) {
			return null;
		}

		// Esse for percorre todos os valores possíveis deste Enum 'TipoCliente'
		for (Tag x : Tag.values()) {
			if (name.equals(x.getName())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid Name: " + name);
	}
	
}
