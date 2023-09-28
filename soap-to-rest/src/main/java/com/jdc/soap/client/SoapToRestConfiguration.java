package com.jdc.soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.jdc.soap.client.service.CalculatorClient;

@Configuration
public class SoapToRestConfiguration {

	@Bean
	Jaxb2Marshaller marshaller() {
		var bean = new Jaxb2Marshaller();
		bean.setContextPath("com.jdc.soap.client.wsdl");
		return bean;
	}
	
	@Bean
	CalculatorClient client(Jaxb2Marshaller marshaller) {
		var bean = new CalculatorClient();
		bean.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		bean.setMarshaller(marshaller);
		bean.setUnmarshaller(marshaller);
		return bean;
	}
}
