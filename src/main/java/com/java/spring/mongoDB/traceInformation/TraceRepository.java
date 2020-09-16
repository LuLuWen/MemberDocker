package com.java.spring.mongoDB.traceInformation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TraceRepository extends MongoRepository<Trace, String> {

}
