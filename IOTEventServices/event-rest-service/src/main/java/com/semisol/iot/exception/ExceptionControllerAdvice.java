package com.semisol.iot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.semisol.iot.dto.Errors;

@ControllerAdvice
public class ExceptionControllerAdvice {
	private static Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errors> exceptionHandler(Exception ex) {
		logger.error("ExceptionControllerAdvice,globalException"+ex.getMessage());
		Errors error = new Errors();
		error.setErrorType(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
		error.setErrorMessage("Please contact your administrator");
		return new ResponseEntity<Errors>(error, HttpStatus.OK);
	}
}
