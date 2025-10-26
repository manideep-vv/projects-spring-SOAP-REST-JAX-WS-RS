package com.ampf.soapDemo.controller;

import com.ampf.soapDemo.dto.Employee;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebService
@Component
//@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class EmployeeController {
    List<Employee> employeeList;

    @WebMethod
    public synchronized String empDetails(String empName) throws InterruptedException {
        System.out.printf("\n currently executing %s 's request \n ", Thread.currentThread().getName());
        Thread.sleep(20000);
        System.out.printf("\n execution of %s thread if over", Thread.currentThread().getName());
        return "Best Employee name is santhoshi and " + empName;
    }

    @WebMethod
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    @PostConstruct
    public  void init(){
        System.out.println("firing init method");
        employeeList= Arrays.asList(
                new Employee("mohan", 200),
                new Employee("mani", 201));
    }
}
