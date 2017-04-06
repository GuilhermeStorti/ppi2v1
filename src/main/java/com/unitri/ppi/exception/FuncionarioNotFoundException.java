package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class FuncionarioNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FuncionarioNotFoundException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
