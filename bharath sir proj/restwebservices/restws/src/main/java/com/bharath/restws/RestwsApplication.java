package com.bharath.restws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestwsApplication.class, args);
	}
	@Bean
	public JAXRSServerFactoryBean jaxRsServer(Bus bus, PatientServiceImpl patientService) {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(bus);
		factory.setResourceClasses(PatientServiceImpl.class);
		factory.setResourceProvider(PatientServiceImpl.class, new SingletonResourceProvider(patientService));
		factory.setAddress("/"); // means /services/
		System.out.println("Creating server bean");
		return factory;
	}
	@Bean
	public ServletRegistrationBean<CXFServlet> cxfServletRegistration() {
		CXFServlet cxfServlet = new CXFServlet();
		ServletRegistrationBean<CXFServlet> registration = new ServletRegistrationBean<>(cxfServlet, "/services/*");
		registration.setLoadOnStartup(1);
		System.out.println("Creating servlet bean");
		return registration;
	}

}
