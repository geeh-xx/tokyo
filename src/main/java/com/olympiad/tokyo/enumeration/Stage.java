package com.olympiad.tokyo.enumeration;

import java.util.Arrays;

public enum Stage {

	ELIMINATORIAS("eliminatorias"),
	OITAVAS("oitavas de final "),
	QUARTAS("quartas de final"),
	SEMIFINAL("semifinal"),
	FINAL("final");
	
	private String value;

	private Stage(String value) {
		this.value = value;
	}

	public static Stage fromValue(String value) {
		for (Stage stage : values()) {
			if (stage.value.equalsIgnoreCase(value)) {
				return stage;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
	
}
