package com.ampf.config;

import com.ampf.controller.ActorController;
import com.ampf.controller.DoctorController;
import com.ampf.handler.IdCardCheckerSOAPHandler;
import jakarta.xml.ws.Binding;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MySOAPEndpointRegistrator implements CommandLineRunner {
    @Autowired
    DoctorController doctorController;

    @Autowired
    ActorController actorController;

    @Autowired
    Bus bus;

    @Autowired
    IdCardCheckerSOAPHandler mySOAPHandler;

    @Override
    public void run(String... args) throws Exception {

        EndpointImpl endpoint =new EndpointImpl(bus,doctorController);
        endpoint.publish("/doctors");
        System.out.println("registered doctor controller");
        endpoint.getBinding().setHandlerChain(List.of(mySOAPHandler));
        System.out.println("configured mySOAP Handler for endpoint1");


        EndpointImpl endpoint1 =new EndpointImpl(bus,actorController);
        endpoint1.publish("/actors");
        endpoint1.getBinding().setHandlerChain(List.of(mySOAPHandler));
        System.out.println("configured mySOAP Handler for endpoint2");




    }
}
