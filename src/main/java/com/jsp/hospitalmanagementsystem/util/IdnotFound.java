package com.jsp.hospitalmanagementsystem.util;

public class IdnotFound extends RuntimeException {

	private String message = "Id not Found";

	@Override
	public String getMessage() {
		return message;

	}

	public IdnotFound(String message) {
		this.message = message;
	}

	public IdnotFound() {
		super();
	}

}
