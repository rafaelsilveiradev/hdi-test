package br.com.test.fakehdi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
	
}
