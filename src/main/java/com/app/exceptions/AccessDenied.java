package com.app.exceptions;

public class AccessDenied extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessDenied() {
		super("Access denied to perform operation");
	}
}
