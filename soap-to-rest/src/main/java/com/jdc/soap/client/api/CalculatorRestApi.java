package com.jdc.soap.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.soap.client.service.CalculatorClient;
import com.jdc.soap.client.wsdl.AddResponse;
import com.jdc.soap.client.wsdl.DivideResponse;
import com.jdc.soap.client.wsdl.MultiplyResponse;
import com.jdc.soap.client.wsdl.SubtractResponse;

@RestController
@RequestMapping
public class CalculatorRestApi {
	
	@Autowired
	private CalculatorClient client;

	@GetMapping("add")
	public AddResponse add(@RequestParam int digit1, @RequestParam int digit2) {
		return client.add(digit1, digit2);
	}

	@GetMapping("subtract")
	public SubtractResponse subtract(@RequestParam int digit1, @RequestParam int digit2) {
		return client.subtract(digit1, digit2);
	}

	@GetMapping("multiply")
	public MultiplyResponse multiply(@RequestParam int digit1, @RequestParam int digit2) {
		return client.multiply(digit1, digit2);
	}

	@GetMapping("divide")
	public DivideResponse divide(@RequestParam int digit1, @RequestParam int digit2) {
		return client.divide(digit1, digit2);
	}
}
