package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class LocacaoAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public LocacaoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public LocacaoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
