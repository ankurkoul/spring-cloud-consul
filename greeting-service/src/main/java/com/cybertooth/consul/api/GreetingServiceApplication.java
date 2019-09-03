package com.cybertooth.consul.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingServiceApplication {

	@GetMapping("/greeting")
	public String getGreeting() {
		return "Hello world from Consul";
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
