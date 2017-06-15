package com.ppi2.locacaoVeiculos.exception;

public class EntityAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public EntityAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
