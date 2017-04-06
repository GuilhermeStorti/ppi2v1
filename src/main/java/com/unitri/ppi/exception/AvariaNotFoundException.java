package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class AvariaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AvariaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public AvariaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
