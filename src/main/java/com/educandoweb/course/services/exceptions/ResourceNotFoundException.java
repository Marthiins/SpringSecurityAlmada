package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {// RuntimeException o copilador não obriga a Tratar

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);

	}

}