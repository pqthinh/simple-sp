package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "test", defaultValue = "true") String test) {
		if(test.equals("true")) return String.format("This just is test. Hello %s !", name);
		return String.format("Hello %s!", name);
	}

	@GetMapping("/")
	public String welcome(@RequestBody(required = false) String test) {
		System.out.println("Test " + test.toString());
		return "Hello";
	}
}
