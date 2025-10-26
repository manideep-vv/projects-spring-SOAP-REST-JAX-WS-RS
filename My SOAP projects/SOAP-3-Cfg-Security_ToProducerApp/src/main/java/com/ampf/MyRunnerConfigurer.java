package com.ampf;

import com.ampf.controller.StudentSOAPController;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyRunnerConfigurer implements CommandLineRunner {
    @Autowired
    Bus bus;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("bus got autowired with hashcode" + bus.hashCode());
        EndpointImpl impl = new EndpointImpl(bus, new StudentSOAPController());
        impl.publish("/student");
        System.out.println("published StudentSOAPController at /student");

        //configuring sec using interceptors
        Map<String, Object> map = new HashMap<>();
        map.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        map.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        map.put(ConfigurationConstants.PW_CALLBACK_CLASS, MyUTPasswordTokenCallback.class.getName());

        WSS4JInInterceptor wss4JInInterceptor = new WSS4JInInterceptor(map);
        impl.getInInterceptors().add(wss4JInInterceptor);
    }
}
