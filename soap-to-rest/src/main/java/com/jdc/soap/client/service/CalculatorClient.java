package com.jdc.soap.client.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.jdc.soap.client.wsdl.Add;
import com.jdc.soap.client.wsdl.AddResponse;
import com.jdc.soap.client.wsdl.Divide;
import com.jdc.soap.client.wsdl.DivideResponse;
import com.jdc.soap.client.wsdl.Multiply;
import com.jdc.soap.client.wsdl.MultiplyResponse;
import com.jdc.soap.client.wsdl.Subtract;
import com.jdc.soap.client.wsdl.SubtractResponse;

public class CalculatorClient extends WebServiceGatewaySupport{

	public AddResponse add(int a, int b) {
		var request = new Add();
		request.setIntA(a);
		request.setIntB(b);
		
		return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), 
				request, new SoapActionCallback("http://tempuri.org/Add"));
	}
	
	public SubtractResponse subtract(int a, int b) {
		var request = new Subtract();
		request.setIntA(a);
		request.setIntB(b);
		return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), 
				request, new SoapActionCallback("http://tempuri.org/Subtract"));
	}
	
	public MultiplyResponse multiply(int a, int b) {
		var request = new Multiply();
		request.setIntA(a);
		request.setIntB(b);
		return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), 
				request, new SoapActionCallback("http://tempuri.org/Multiply"));
	}
	
	public DivideResponse divide(int a, int b) {
		var request = new Divide();
		request.setIntA(a);
		request.setIntB(b);
		return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), 
				request, new SoapActionCallback("http://tempuri.org/Divide"));
	}
	
	
}
