package com.java.spring.mongoDB.security;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(enableByDefault=true, id="sample")
public class SampleEndpoint {
	
	@ReadOperation
	public Sample getSampleEndpoint()
	{
		return new Sample("sravan","kumar");
	}
	@ReadOperation
	public Sample getUserSample(@Selector String title, @Selector String message)
	{
		return new Sample(title,message);
	}
	@WriteOperation
	public void writeSample(@Selector String title, @Selector String message)
	{
		System.out.println("write operation with title:"+title +" and message "+message);
	}
	@DeleteOperation
	public void deleteSample(@Selector String title)
	{
		System.out.println("delete operation with title:"+title);
	}
}
