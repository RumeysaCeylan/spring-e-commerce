package com.example.commerce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = "com.example.commerce")
public class SpringEcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringEcommerceApplication.class, args);
	}

}


