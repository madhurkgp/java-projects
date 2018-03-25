package com.exception;

public class InvalidStateException extends Exception {
	public InvalidStateException() {
		System.out.println("error: required state is not present");
	}
}
