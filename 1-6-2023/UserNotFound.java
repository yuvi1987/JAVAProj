package com.dal.Exception;

public class UserNotFound extends Exception {
	public UserNotFound() {
		System.out.println("User not found");
	}

	@Override
	public String toString() {
		return "ExceptionHandle UserNotFound";
	}
	
}
