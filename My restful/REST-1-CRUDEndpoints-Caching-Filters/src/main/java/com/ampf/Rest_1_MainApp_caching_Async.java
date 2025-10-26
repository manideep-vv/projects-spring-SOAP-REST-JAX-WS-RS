package com.ampf;

import com.ampf.controller.AdvisorController;
import com.ampf.controller.CarControllerWithCaching;
import com.ampf.controller.EmployeeControllerAsync;
import com.ampf.controller.PatientController;
import com.ampf.exceptionmappers.AWMServiceExceptionMapper;
import com.ampf.filter.AIPACAuthFilter;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
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
    AdvisorController  advisorController;

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
        JacksonJsonProvider jsonProvider=new JacksonJsonProvider();
        AWMServiceExceptionMapper awmServiceExceptionMapper=new AWMServiceExceptionMapper();
        server.setBus(bus);
        server.setAddress("/");
        server.setServiceBeans(List.of(patientController,asyncController, carControllerWithCaching,advisorController));
        server.setResourceClasses(PatientController.class);
        server.setProviders(List.of(aipacAuthFilter,jsonProvider,awmServiceExceptionMapper));
        System.out.println("created a bean from config class without adding filter ");
        return  server.create();
    }

}
