package com.java.spring.mongoDB.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.spring.mongoDB.model.Member;

public interface MemberRepository extends MongoRepository<Member, Integer>{

	List<Member> findByPassword(String password);
	
	List<Member> findByAddress(String address);
}
