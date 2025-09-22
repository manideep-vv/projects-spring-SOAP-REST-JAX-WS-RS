package com.ampf.controller;

import com.ampf.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import org.springframework.stereotype.Component;

@Path("/employee")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Component
public class EmployeeControllerAsync {

    @Path("/get")
    @POST
    public void getEmployee(@Suspended AsyncResponse async, Employee empReqBody,@QueryParam("empNameQueryP") String empNameQueryP) throws InterruptedException {
        System.out.println("req received");
        Thread.sleep(5000);
        // once output arrived then send that to resume method
        Employee newEmp = Employee.builder().name(empNameQueryP.toUpperCase()).id(empReqBody.getId()).build();
        async.resume(newEmp);
        System.out.println(" response sent");
    }

    @Path("/get")
    @GET
    public Employee getEmployee1(@QueryParam("empName") String empName) throws InterruptedException {
        Thread.sleep(5000);
        // once output arrived then send that to resume method
        Employee newEmp = Employee.builder().name(empName).build();
        System.out.println("Executing emp endpoint class");
        return newEmp;
    }

    @PostConstruct
    public void init(){
        System.out.println("instantiated emp controller class ");
    }
}
