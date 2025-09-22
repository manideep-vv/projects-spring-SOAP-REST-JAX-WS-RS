package com.ampf.consumers;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

public class MyJaxRsWebClientCon {
    public static void main(String[] args) {

        WebClient webClient = WebClient.create("http://localhost:8080/services/helloservice");
        Response response = webClient.accept(MediaType.APPLICATION_XML)
                .path("/patients/all")
                .get();
        System.out.println(response.getEntity());

    }


}
