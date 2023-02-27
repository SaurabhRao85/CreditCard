package com.axis.exception;

import org.springframework.validation.Errors;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends RuntimeException {

	private Errors errors;

    public ValidationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
        
        
}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
}
