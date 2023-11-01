package br.com.fpimentel.clientapi.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fpimentel.clientapi.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandardError> objectNotFound(NullPointerException ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.NOT_FOUND.value(),
					request.getRequestURI())		
				);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.NOT_FOUND.value(),
					request.getRequestURI())		
				);
	}
}
