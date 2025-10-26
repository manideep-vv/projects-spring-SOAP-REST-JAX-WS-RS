package com.ampf.soapDemo.controller;

//import jakarta.jws.WebMethod;
//import jakarta.jws.WebService;

import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Component
public class StudentSOAPController {
    @WebMethod
    public String getStudentName(){


        return "Millet Follower Mani";
    }
    @WebMethod
    public  String getStudentAddress(){
        return  "charan from chirala";
    }
}
