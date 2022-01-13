package com.management.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;

@SpringBootApplication
@CrossOrigin
public class ApiApplication {

    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class, args);
        SpringApplication app = new SpringApplication(ApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3333"));
        app.run(args);
    }

}
