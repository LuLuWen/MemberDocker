package com.java.spring.mongoDB.traceInformation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "trace")
public class Trace {
	
	private String timeStamp;
	private String request_method;
	private String request_uri;
	private String response_status;
	private String timeTaken;
	
	@Id
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getRequest_method() {
		return request_method;
	}
	public void setRequest_method(String request_method) {
		this.request_method = request_method;
	}
	public String getRequest_uri() {
		return request_uri;
	}
	public void setRequest_uri(String request_uri) {
		this.request_uri = request_uri;
	}
	public String getResponse_status() {
		return response_status;
	}
	public void setResponse_status(String response_status) {
		this.response_status = response_status;
	}
	public String getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}
	
	
}
