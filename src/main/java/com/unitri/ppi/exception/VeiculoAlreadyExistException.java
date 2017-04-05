package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class VeiculoAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public VeiculoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public VeiculoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
