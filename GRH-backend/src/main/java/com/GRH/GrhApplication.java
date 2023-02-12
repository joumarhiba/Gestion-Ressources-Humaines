package com.GRH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class GrhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrhApplication.class, args);
	}

}
