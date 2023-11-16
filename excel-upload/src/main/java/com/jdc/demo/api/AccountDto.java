package com.jdc.demo.api;

public record AccountDto(
		String headerCode,
		String headerName,
		String detailsCode,
		String detailsName
		){

	public static AccountDto from(String [] array) {
		return new AccountDto(array[0], array[1], array[2], array[3]);
	}
}
