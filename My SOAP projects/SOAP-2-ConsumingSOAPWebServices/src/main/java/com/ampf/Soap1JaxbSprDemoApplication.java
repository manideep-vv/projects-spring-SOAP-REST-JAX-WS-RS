package com.ampf;

import com.ampf.controller.StudentSOAPController;
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


//    @Autowired
//    Bus bus;


//    @PostConstruct
//    public void init() throws IOException {
//        System.out.println("bus got autowired with hashcode" + bus.hashCode());
//        EndpointImpl impl = new EndpointImpl(bus, new StudentSOAPController());
//        impl.publish("/student");
//        System.out.println("published StudentSOAPController at /student");
//    }
    @PostConstruct
    public void init() throws IOException {
        System.out.println("container started");
    }
}
