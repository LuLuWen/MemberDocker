package com.java.spring.mongoDB.security;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.mongoDB.controller.LoggingController;

public class RemoteHttpTraceRepository implements HttpTraceRepository {

	Logger logger = LoggerFactory.getLogger(RemoteHttpTraceRepository.class);
	
	@Override
	public List<HttpTrace> findAll() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
    @RequestMapping("/testTrace")
	public void add(HttpTrace trace) {
		
		// TODO Auto-generated method stub
		//String path = trace.getRequest().getUri().getPath();
        //String queryPara = trace.getRequest().getUri().getQuery();
        //String queryParaRaw = trace.getRequest().getUri().getRawQuery();
        //String method = trace.getRequest().getMethod();
        long timeTaken = trace.getTimeTaken();
        //String time = trace.getTimestamp().toString();
        //logger.info("path: {}, queryPara: {}, queryParaRaw: {}, timeTaken: {}, time: {}, method: {}", path, queryPara, queryParaRaw,
         //       timeTaken, time, method);
        logger.info("timeTaken: {}", timeTaken);
	}

}
