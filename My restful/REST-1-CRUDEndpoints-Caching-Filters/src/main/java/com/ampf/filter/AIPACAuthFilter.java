package com.ampf.filter;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import org.springframework.stereotype.Component;

import java.io.IOException;

@PreMatching
@Provider
@Component
public class AIPACAuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Executing filter ");
        System.out.println(requestContext.getHeaderString("HeroName"));
    }
    @PostConstruct
    public void init(){
        System.out.println("created filter object");
    }
}
