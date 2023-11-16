package com.jdc.demo.model;

public record CountryWithStateName(
		CountryDto country,
		String state
		) {

	public CountryWithStateName(int id, String name, String state) {
		this(new CountryDto(id, name), state);
	}
}
