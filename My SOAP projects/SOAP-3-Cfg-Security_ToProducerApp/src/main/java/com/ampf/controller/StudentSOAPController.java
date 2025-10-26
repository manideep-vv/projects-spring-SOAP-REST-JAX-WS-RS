package com.ampf.controller;

//import jakarta.jws.WebMethod;
//import jakarta.jws.WebService;

import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;
import org.springframework.stereotype.Component;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
@Component
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class StudentSOAPController {
    @WebMethod
    public String getStudentName() {
        return "Millet Follower Mani";
    }

    @WebMethod
    public String getStudentAddress() {
        return "charan from chirala";
    }
}
