package com.jdc.demo.model;

import java.util.List;

import com.jdc.demo.entity.Country;

public record CountryWithStateNameDto(
		int id,
		String name,
		List<String> states
		) {

	public static CountryWithStateNameDto from(Country c) {
		return new CountryWithStateNameDto(c.getId(), c.getName(), c.getStates().stream().map(a -> a.getName()).toList());
	}
	
	public static CountryWithStateNameDto from(CountryDto dto, List<String> states) {
		return new CountryWithStateNameDto(dto.id(), dto.name(), states);
	}
}
