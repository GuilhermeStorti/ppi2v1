package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class FuncionarioAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FuncionarioAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
