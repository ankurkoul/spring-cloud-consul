package com.cybertooth.consul.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UserServiceApplication {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient client;

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@GetMapping("/fetch")
	public String consumeGreetings() {

//URI url=client.getInstances("greeting-service").stream().map(si->si.getUri()).findFirst().get();
//url======>http://localhost:8181

		URI url = client.getInstances("greeting-service").stream().map(si -> si.getUri()).findFirst()
				.map(s -> s.resolve("/greeting")).get();
		//url======>http://localhost:8181/greeting

		return restTemplate.getForObject(url, String.class);
	}

}
