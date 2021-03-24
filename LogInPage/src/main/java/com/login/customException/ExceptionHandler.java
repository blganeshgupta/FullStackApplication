package com.login.customException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<?> customErrorValidator(MethodArgumentNotValidException exception){
	ErrorModel errorDetails=new ErrorModel(new Date(),"Validation error" , exception.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	
	
}
}
