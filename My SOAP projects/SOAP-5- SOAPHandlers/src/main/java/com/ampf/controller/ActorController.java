package com.ampf.controller;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import org.springframework.stereotype.Component;

import java.util.List;


@WebService
@Component
public class ActorController {
    @WebMethod
    public List<String> getAllHeroNames() {
        return List.of("Venky","chiru");
    }

    @WebMethod
    public List<String> getAllHeroinNames() {
        return List.of("Kajal","tammanna");
    }
}
