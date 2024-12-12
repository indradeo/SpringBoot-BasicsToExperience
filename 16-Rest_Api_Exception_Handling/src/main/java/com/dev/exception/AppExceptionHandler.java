package com.dev.exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e){
		
		String exMsg=e.getMessage();
		ErrorInfo info= new ErrorInfo();
		info.setCode("Rde3452");
		info.setMsg(exMsg);
		info.setWhen(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserNotFound(UserNotFoundException e){
		ErrorInfo info = new ErrorInfo();
		info.setMsg(e.getMessage());
		info.setCode("user404");
		info.setWhen(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(info,HttpStatus.BAD_REQUEST);
	}
}
