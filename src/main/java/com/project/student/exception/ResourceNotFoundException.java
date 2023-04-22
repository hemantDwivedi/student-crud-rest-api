package com.project.student.exception;

/**
 * ResourceNotFoundException class handles the resource not found exception.
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
