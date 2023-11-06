package br.com.fpimentel.productapi.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StandardError {
	
	private LocalDateTime timestamp;
	private String error;
	private Integer status;
	private String path;

	public StandardError(LocalDateTime now, String message, HttpStatus insufficientStorage, String requestURI) {
		// TODO Auto-generated constructor stub
	}

}
