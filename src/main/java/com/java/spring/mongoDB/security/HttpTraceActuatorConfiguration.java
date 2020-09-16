package com.java.spring.mongoDB.security;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(InMemoryHttpTraceRepository.class)
//@Profile("actuator-endpoints") /* if you want: register bean only if profile is set */
public class HttpTraceActuatorConfiguration {

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		InMemoryHttpTraceRepository inMemoryHttpTraceRepository = new InMemoryHttpTraceRepository();
        inMemoryHttpTraceRepository.setCapacity(150);
        return inMemoryHttpTraceRepository;
	}

}