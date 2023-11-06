package br.com.fpimentel.productapi.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fpimentel.productapi.services.impl.exceptions.InsufficientStockException;
import br.com.fpimentel.productapi.services.impl.exceptions.ObjectNotFoundExceprion;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(InsufficientStockException.class)
	 public ResponseEntity<StandardError> InsufficientStock(InsufficientStockException ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.NOT_FOUND.value(),
					request.getRequestURI()
						)
				);
		
	 }
	
	@ExceptionHandler(ObjectNotFoundExceprion.class)
	 public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExceprion ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.NOT_FOUND.value(),
					request.getRequestURI()
						)
				);
		
	 }
}
