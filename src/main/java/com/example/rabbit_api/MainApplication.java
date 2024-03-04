package com.example.rabbit_api;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/spring-boot")
public class MainApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(MainApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}

}
