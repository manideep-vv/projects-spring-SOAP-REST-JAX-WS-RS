package com.ampf.controller;

import com.ampf.model.FailureResponse;
import com.ampf.model.Patient;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    /**
     * localhost:8080/services/helloservice/patients/patient/mani
     * @param name
     * @return
     */

    @Path("/patient/{name}")
    @GET
    public Patient getPatientPathParamDemo(@PathParam("name") String name){
        System.out.println("executing single patient method");
        if(name==null || name.equalsIgnoreCase("mani")){
            System.out.println("thworing bad requ");
            FailureResponse response=FailureResponse.builder().failureCode("400_AIPAC").failureReason("Wrong input").build();
            Response badRequest = Response.status(Response.Status.BAD_REQUEST)
                    .entity(response)
                    .type(MediaType.APPLICATION_XML)
                    .build();
            throw new BadRequestException(badRequest);
        }
        return Patient.builder().name(name).build();
    }

    /**
     * localhost:8080/services/helloservice/patients/queryPatient?patientName=santu
     * @param name
     * @param vendorName
     * @param cookeyName
     * @return
     */
    @Path("/queryPatient")
    @GET
    public Patient getPatientUsingQueryAndHeaderParam(@QueryParam("patientName") String name, @HeaderParam("vendor")String vendorName,@CookieParam("secretAgent") String cookeyName){
        System.out.println("in query param method fetch query param name is ---> "+name);
        System.out.println("fetch header param name is ---> "+vendorName);
        System.out.println("fetched from cookies as  ---> "+cookeyName);

        if(name==null || "mani".equalsIgnoreCase(name) ){
            System.out.println("thworing bad requ");
            FailureResponse response=FailureResponse.builder().failureCode("40000_AHT").failureReason("Wrong input").build();
            Response resp=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
            throw new InternalServerErrorException(resp);
        }

        return Patient.builder().name(name+"--from "+vendorName).build();
    }

    /**
     * localhost:8080/services/helloservice/patients/parseCookies
     * @param cookeyName
     * @param request
     * @param httpResponse
     * @return
     */

    @Path("/parseCookies")
    @GET
    public Patient getPatientUsingCookieParam(@CookieParam("secretAgent") String cookeyName, @Context HttpServletRequest request, @Context HttpServletResponse httpResponse){
        System.out.println("fetched using @CookieParam cookies as  ---> "+cookeyName);
        httpResponse.setHeader("Set-Cookie","JSESSIONIDP=ABCD; HttpOnly; Secure; SameSite=Strict");

        if(cookeyName==null || "mani".equalsIgnoreCase(cookeyName) ){
            System.out.println("thworing bad requ");
            FailureResponse response=FailureResponse.builder().failureCode("40000_AHT").failureReason("Wrong input").build();
            Response resp=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
            throw new InternalServerErrorException(resp);
        }
        return Patient.builder().name("cookie--"+cookeyName).build();
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
