package br.com.fpimentel.productapi.services.impl.exceptions;

public class ObjectNotFoundExceprion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExceprion(String message) {
		super(message);
	}

}
