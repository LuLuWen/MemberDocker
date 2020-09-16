package com.java.spring.mongoDB.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.mongoDB.model.Member;
import com.java.spring.mongoDB.repository.MemberRepository;

@RestController
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("/addMember")
	public ResponseEntity<Member> savaMember(@RequestBody Member member) {
		memberRepository.save(member);
		logger.info("Success in adding a member {}",member);
		return new ResponseEntity<Member>(member, HttpStatus.CREATED);
	}
	
	@GetMapping("/findAllMembers")
	public ResponseEntity<List<Member>> getMembers() {
		int i;
		for(i = 0; i < 5 ; i++) {
			//System.out.println(i);
			i = (int)(Math.random() * 5) + 1; //產生1-5亂數
			System.out.println(i);
			if(i == 3) {
				logger.warn("fail to find members");
				List<Member> memberList = new ArrayList<Member>();
				return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
			}
		}
		
		List<Member> memberList = memberRepository.findAll();
		logger.info("Success in finding all the members");
		return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
	}
	
	@GetMapping("/findMember/{id}")
	public ResponseEntity<Member> getMember(@PathVariable int id) {
		Optional<Member> member = memberRepository.findById(id);
		logger.info("Success in finding a member whose id is {} , {}",id , member.get());
		return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMember/{id}")
	public ResponseEntity<HttpStatus> deleteMember(@PathVariable int id) {
		memberRepository.deleteById(id);
		logger.info("Success in deleting a member whose id is {}",id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updateMember/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
		member.setId(id);
		logger.info("Success in updating a member whose id is {}",id);
	    return new ResponseEntity<Member>(memberRepository.save(member), HttpStatus.OK);
	}
	
	@GetMapping("/findMemberByPassword/{password}")
	public ResponseEntity<List<Member>> getMember1(@PathVariable String password) {
		List<Member> member = memberRepository.findByPassword(password);
		return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
	}
	
	@GetMapping("/findMemberByAddress/{address}")
	public ResponseEntity<List<Member>> getMember2(@PathVariable String address) {
		List<Member> member = memberRepository.findByAddress(address);
		return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
	}
	
	@GetMapping("/findAllMembersBySort")
	public ResponseEntity<List<Member>> getMembers1() {
		List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
	}
}
