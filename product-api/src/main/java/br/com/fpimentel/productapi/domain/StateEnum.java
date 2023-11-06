package br.com.fpimentel.productapi.domain;

public enum StateEnum {
	
	
	UNAVAILABLE("Unavailable"),
	AVAILABLE("Available");
	
	private String states;
	
	StateEnum(String states) {
		this.states = states;
	}
	
	public String getStates() {
		return this.states;
	}

}
