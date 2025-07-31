package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface PaymentProcessor {

	@WebMethod
	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest);
//	public @WebResult PaymentProcessorResponse processPayment(@WebParam PaymentProcessorRequest paymentProcessorRequest);
}
