package com.ampf.controller;

import com.ampf.exceptionmappers.AdvisorNotFoundException;
import com.ampf.model.Advisor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@Path("/advisors")
public class AdvisorController {

    /**
    This is post method demo this can be invoked using localhost:8080/services/advisors/getState
     * {
     *     "id":"123",
     *     "state":"Andhra pradesh"
     * }
     */
    @Path("/getState")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAdvisorState(Advisor advisor){
        System.out.println("in advisor controller method");
        String data = "Entered advisor state is --> " + advisor.getState();
        return Response.status(Response.Status.OK)
                .header("country","china")
                .type(MediaType.APPLICATION_JSON)
                .entity(data).build();
    }

    @Path("/{advisorId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAdvisorsList(@PathParam("advisorId") String id){
        if(id.equalsIgnoreCase("a")){
            throw new AdvisorNotFoundException();
        }
        System.out.println("received advisor id is  "+id);
        Advisor advisor=Advisor.builder().state("TN").id("123").build();
        Advisor advisor2=Advisor.builder().state("AP").id("321").build();
       return Response.status(Response.Status.OK)
                .entity(List.of(advisor2,advisor)).build();
    }

    @Path("/formAnnoDemo")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response formParamDemo(@FormParam("state")String stateName){

        System.out.println("in advisor controller method");
        return Response.ok("Entered advisor state is --> "+stateName).build();
    }
}
