package com.ampf.consumers;

import com.ampf.model.Employee;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EmpAsyncConsumer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/helloservice/employee/get?empNameQueryP=charanYoutuber");
        AsyncInvoker asyncInvoker = target.request().async();
        Employee emp = Employee.builder().id("250512").build();
        Future<Employee> response = asyncInvoker.post(Entity.entity(emp, MediaType.APPLICATION_XML_TYPE), Employee.class);
        Employee employee = response.get();
        System.out.println("response is -->"+employee);
    }
}
