package com.bharath.ws.soap;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavafirstwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavafirstwsApplication.class, args);
	}

	@Autowired
	Bus  bus;

	@Autowired
	PaymentProcessorImpl paymentProcessor;

	@PostConstruct
	public void init(){
		EndpointImpl endpoint=new EndpointImpl(bus,paymentProcessor);
		endpoint.publish("/pay");
		System.out.println("published an endpoint");

	}
}
