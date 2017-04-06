package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class CategoriaAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CategoriaAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public CategoriaAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
