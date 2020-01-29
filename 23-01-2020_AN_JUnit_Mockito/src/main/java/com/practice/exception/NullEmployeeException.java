package com.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found")
public class NullEmployeeException extends Exception {

	private static final long serialVersionUID = -123121987;

	public NullEmployeeException(){
		super("No Emplpyee Record Found!");
	}
}
