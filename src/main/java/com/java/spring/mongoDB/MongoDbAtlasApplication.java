package com.java.spring.mongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class MongoDbAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbAtlasApplication.class, args);
	}

}
