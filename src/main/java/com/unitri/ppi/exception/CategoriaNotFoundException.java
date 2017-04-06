package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class CategoriaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CategoriaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public CategoriaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
