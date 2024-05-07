package com.sample.logistics.exception;

public class ConstraintException extends RuntimeException {

	public ConstraintException(String message) {
		super(message);
	}

	public ConstraintException() {
		super();
	}

}
