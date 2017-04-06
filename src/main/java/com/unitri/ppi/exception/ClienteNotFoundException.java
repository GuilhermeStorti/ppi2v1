package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class ClienteNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ClienteNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
