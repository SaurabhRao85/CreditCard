package com.axis.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormException {
	@JsonProperty("status_code")
    private String status_code;
	@JsonProperty("message")
    private String message;
	@JsonProperty("errors")
    private List<FieldException> fieldErrors;
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FieldException> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(List<FieldException> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	

}
