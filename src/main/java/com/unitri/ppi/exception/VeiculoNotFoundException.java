package com.unitri.ppi.exception;

/**
 * Created by guilherme on 05/04/17.
 */
public class VeiculoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VeiculoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public VeiculoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
