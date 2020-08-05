package com.nextgeneration.dtos;

import lombok.Data;

@Data
public class ResponseEntity {
	
	private int status;
	private Object message;
	private String errorMessage;
	private boolean error;
	
	public ResponseEntity() {
		this.status = 200;
		this.message = "";
		this.error = false;
		this.errorMessage = "";
	}
	
	public ResponseEntity setMessage(Object message, int status) {
		this.message = message;
		this.status = status;
		return this;
	}

	public ResponseEntity setErrorMessage(String errorMessage, int status) {
		this.errorMessage = errorMessage;
		this.status = status;
		this.error = true;
		return this;
	}
}
