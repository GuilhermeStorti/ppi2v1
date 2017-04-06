package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class AvariaAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AvariaAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public AvariaAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
