package com.coolcoder.exception;

/**
 * Thrown when a requested resource (e.g., Order, User, Book) is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
