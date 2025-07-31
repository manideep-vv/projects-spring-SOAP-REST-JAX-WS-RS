package com.ampf;

import com.ampf.controller.PatientController;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ampf.controller"})
public class Rest_1_MainApp {
    @Autowired
    Bus bus;

    @Autowired
    PatientController controller;
    public static void main(String[] args) {
        SpringApplication.run(Rest_1_MainApp.class,args);
    }
    @Bean
    public Server rsserver(){

        System.out.println(" creating bean ");
        JAXRSServerFactoryBean endPoint =new JAXRSServerFactoryBean();
        endPoint.setBus(bus);
        endPoint.setAddress("/");
        endPoint.setServiceBeans(List.of(controller));
        System.out.println("created a bean from config class");
        return  endPoint.create();
    }
}
