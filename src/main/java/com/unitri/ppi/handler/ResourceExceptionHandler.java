package com.unitri.ppi.handler;


import com.unitri.ppi.exception.ErrorDetails;
import com.unitri.ppi.exception.VeiculoAlreadyExistException;
import com.unitri.ppi.exception.VeiculoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice

public class ResourceExceptionHandler {

    @ExceptionHandler(VeiculoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerVeiculoNotFoundException(VeiculoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Veiculo not found.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(VeiculoAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerVeiculoAlreadyExistException(VeiculoAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409l);
        error.setTitle("Veiculo already exist.");
        error.setUrl("http://erros.teste.com/409");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
