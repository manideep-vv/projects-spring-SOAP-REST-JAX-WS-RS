package com.ampf.exceptionmappers;

import com.ampf.model.ErrorContainer;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AWMServiceExceptionMapper implements ExceptionMapper<AdvisorNotFoundException> {
    @Override
    public Response toResponse(AdvisorNotFoundException exception) {
        return Response.status(Response.Status.CREATED)
                //for this entity method we can pass any object
                .entity(ErrorContainer.builder().errDetails("advisor details are incorrect bro").build())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}

