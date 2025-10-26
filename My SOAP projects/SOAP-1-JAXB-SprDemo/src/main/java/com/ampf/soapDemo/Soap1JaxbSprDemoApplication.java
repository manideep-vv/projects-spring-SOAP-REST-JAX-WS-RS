package com.ampf.soapDemo;

import com.ampf.soapDemo.controller.EmployeeController;
import com.ampf.soapDemo.controller.StudentSOAPController;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class Soap1JaxbSprDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Soap1JaxbSprDemoApplication.class, args);
	}

	@Autowired
	Bus bus;

	@Autowired
	EmployeeController employeeController;

	@Autowired
	StudentSOAPController studentSOAPController;

	@PostConstruct
	public  void init() throws IOException {
		EndpointImpl impl=new EndpointImpl(bus,studentSOAPController);
		impl.publish("/hello");
		System.out.println("fired post construct method");
		EndpointImpl impl2= new EndpointImpl(bus,employeeController);
		impl2.publish("/employee");
	}
}
