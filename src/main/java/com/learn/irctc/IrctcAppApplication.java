package com.learn.irctc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.learn.irctc.entities"})
public class IrctcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcAppApplication.class, args);
	}

}
