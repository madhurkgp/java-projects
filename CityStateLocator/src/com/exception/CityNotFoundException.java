package com.exception;

public class CityNotFoundException extends Exception {
	public CityNotFoundException() {
		System.out.println("error: required city is not present");
	}
}
