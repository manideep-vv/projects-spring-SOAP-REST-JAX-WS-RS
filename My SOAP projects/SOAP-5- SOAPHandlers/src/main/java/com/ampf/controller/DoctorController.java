package com.ampf.controller;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService
public class DoctorController {

    @WebMethod
    public List<String> getAllDoctorNames() {
        System.out.println("hitting controller method -get doctor names.....");
        return List.of("T.NagaLakshmi", "Munny", "seema kumari");
    }
}
