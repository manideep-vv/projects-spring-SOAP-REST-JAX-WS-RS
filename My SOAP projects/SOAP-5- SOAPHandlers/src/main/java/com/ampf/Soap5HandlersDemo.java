package com.ampf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class Soap5HandlersDemo {

    public static void main(String[] args) {
        SpringApplication.run(Soap5HandlersDemo.class, args);
    }


    @PostConstruct
    public void init() throws IOException {
        System.out.println("container started");
    }
}
