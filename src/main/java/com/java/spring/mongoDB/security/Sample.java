package com.java.spring.mongoDB.security;

import java.io.Serializable;

public class Sample implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String message;

	public Sample(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}
}
