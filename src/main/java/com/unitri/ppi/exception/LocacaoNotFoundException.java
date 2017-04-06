package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class LocacaoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LocacaoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public LocacaoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
