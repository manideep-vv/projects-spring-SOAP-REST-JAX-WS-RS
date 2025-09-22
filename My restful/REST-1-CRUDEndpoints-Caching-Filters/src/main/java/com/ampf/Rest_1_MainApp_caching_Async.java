package com.ampf;

import com.ampf.controller.CarControllerWithCaching;
import com.ampf.controller.EmployeeControllerAsync;
import com.ampf.controller.PatientController;
import com.ampf.filter.AIPACAuthFilter;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ampf.controller"})
public class Rest_1_MainApp_caching_Async {
    @Autowired
    Bus bus;

    @Autowired
    PatientController patientController;

    @Autowired
    CarControllerWithCaching carControllerWithCaching;

    @Autowired
    AIPACAuthFilter aipacAuthFilter;


    @Autowired
    EmployeeControllerAsync asyncController;

    public static void main(String[] args) {
        SpringApplication.run(Rest_1_MainApp_caching_Async.class,args);
    }

    /**
     * create only 1 jax-rs server for 1 app else memory issues
     */
    @Bean
    public Server rsserver(){
        JAXRSServerFactoryBean server =new JAXRSServerFactoryBean();
        server.setBus(bus);
        server.setAddress("/");
        server.setServiceBeans(List.of(patientController,asyncController, carControllerWithCaching));
        server.setProviders(List.of(aipacAuthFilter));
        System.out.println("created a bean from config class without adding filter ");
        return  server.create();
    }

}
