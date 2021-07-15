package com.dlsys.sifood.ums.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dlsys.sifood.ums.dto.GenericResponse;



@RestController
@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public final ResponseEntity<Object> handleException(CannotCreateTransactionException ex, WebRequest request){
	
		GenericResponse response = new GenericResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Internal Server Error", GenericResponse.toList(ex.getMessage()));
	
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
