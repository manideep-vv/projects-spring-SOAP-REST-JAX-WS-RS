package com.ampf.controller;

import com.ampf.model.Patient;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/patients")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Component
public class PatientController {

    HashMap<Integer, Patient> patients;

    @Path("/all")
    @GET
    public List<Patient> getAllPatients(){
        System.out.println("invoking the getter method");
        return new ArrayList<>(patients.values());
    }

    @PostConstruct
    public void init(){
        patients=new HashMap<>();
        System.out.println("executing post construct");
        int id=111;
        patients.put(id,new Patient(id,"santu"));
        id=222;
        patients.put(id,new Patient(id,"radhika"));

    }
}
