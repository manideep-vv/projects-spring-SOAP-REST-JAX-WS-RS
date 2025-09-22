package com.ampf.controller;

import com.ampf.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Path("/carSvc")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Component
public class CarControllerWithCaching {

    /**
     * http://localhost:8080/services/carSvc/getCar?name=BMW
     * @param carName
     * @return
     */
    @GET
    @Path("/getCar")
    public Response getCar(@QueryParam("name") String carName) {
        System.out.println("invoked controller");
        ZonedDateTime zonedDateTime = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.of("Asia/Kolkata"));
        Instant instant = zonedDateTime.toInstant();
        Date from = Date.from(instant);

        Car car = Car.builder().name(carName).brand("Suzuki").id(Math.round(Math.random()*500)).build();
        Response r = Response.ok(car)
                .expires(from)
                .build();

        return r;
    }
    @PostConstruct
    public void init(){
        System.out.println("instantiated car controller class ");
    }

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = LocalDateTime.now().plusMinutes(2).atZone(ZoneId.of("Asia/Kolkata"));
        Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);
    }
}
