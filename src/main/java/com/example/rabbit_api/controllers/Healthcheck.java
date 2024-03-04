package com.example.rabbit_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("/rabbit/")
public class Healthcheck {

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() throws IOException, TimeoutException {
        return new ResponseEntity("Running", HttpStatus.OK) ;
    }

}
