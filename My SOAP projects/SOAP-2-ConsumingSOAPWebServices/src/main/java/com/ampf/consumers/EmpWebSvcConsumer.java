package com.ampf.consumers;


import com.ampf.soapdemo.controller.Employee;
import com.ampf.soapdemo.controller.EmployeeController;
import com.ampf.soapdemo.controller.EmployeeControllerService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class EmpWebSvcConsumer {

    public static void main(String[] args) throws MalformedURLException {
        EmployeeControllerService svc= new EmployeeControllerService(new URL("http://localhost:8080/employee?wsdl"));
        EmployeeController employeeController = svc.getEmployeeControllerPort();
        List<Employee> allEmployees = employeeController.getAllEmployees();
        System.out.println("printing all objects received from controller");
        allEmployees.forEach(e-> System.out.println(e));
    }
}
