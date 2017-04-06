package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class MultaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MultaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public MultaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
