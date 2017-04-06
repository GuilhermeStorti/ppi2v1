package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class ClienteAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public ClienteAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
