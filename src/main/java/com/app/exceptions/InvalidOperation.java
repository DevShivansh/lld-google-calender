package com.app.exceptions;

public class InvalidOperation extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOperation(String message) {
		super(message);
	}
}
