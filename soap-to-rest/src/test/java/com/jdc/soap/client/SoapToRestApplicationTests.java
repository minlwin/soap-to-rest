package com.jdc.soap.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.soap.client.service.CalculatorClient;

@SpringBootTest
class SoapToRestApplicationTests {
	
	@Autowired
	private CalculatorClient client;

	@Test
	void contextLoads() {
		var result = client.add(10, 5);
		assertNotNull(result);
		System.out.println(result.getAddResult());
	}

}
