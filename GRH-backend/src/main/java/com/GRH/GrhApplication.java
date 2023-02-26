package com.GRH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = {"com.GRH.model"})
public class GrhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrhApplication.class, args);
	}

}
