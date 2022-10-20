package com.books.exceptions;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<MyErrorDetails> booksException(BookException b,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails(req.getDescription(false), LocalDate.now(), b.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalHandler(Exception e,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails(req.getDescription(false),LocalDate.now(), e.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFound(NoHandlerFoundException no,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails(req.getDescription(false), LocalDate.now(), no.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
		
	}
	
}
