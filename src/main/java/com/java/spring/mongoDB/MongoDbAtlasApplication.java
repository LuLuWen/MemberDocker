package com.java.spring.mongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MongoDbAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbAtlasApplication.class, args);
	}

}
