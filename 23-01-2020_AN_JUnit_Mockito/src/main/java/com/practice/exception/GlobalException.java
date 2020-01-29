package com.practice.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Detected:: URL="+request.getRequestURL());
		return "db_connection_error";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException detected")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		logger.error("IOException handled");
	}
}

