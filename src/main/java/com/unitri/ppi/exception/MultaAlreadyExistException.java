package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class MultaAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MultaAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public MultaAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
