package com.lps.loan.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> controllerException(Exception e) {
		Map<String, Object> errordetail = new HashMap<String, Object>();
		errordetail.put("message", e.getLocalizedMessage());
		errordetail.put("detail", e.getMessage());
		
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("error", errordetail);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
