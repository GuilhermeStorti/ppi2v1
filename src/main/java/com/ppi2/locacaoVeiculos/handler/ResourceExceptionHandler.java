package com.ppi2.locacaoVeiculos.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ppi2.locacaoVeiculos.exception.EntityAlreadyExistException;
import com.ppi2.locacaoVeiculos.exception.EntityNotFoundException;
import com.ppi2.locacaoVeiculos.exception.ErrorDetails;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerFuncionarioNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
		e.printStackTrace();
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setStatus(404L);
		errorDetails.setTitle("Entity not found.");
		errorDetails.setUrl("http://erros.teste.com/404");
		errorDetails.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}
	
	@ExceptionHandler(EntityAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerFuncionarioAlreadyException(EntityAlreadyExistException e, HttpServletRequest request) {
		e.printStackTrace();
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setStatus(409L);
		errorDetails.setTitle("Entity already exist.");
		errorDetails.setUrl("http://erros.teste.com/409");
		errorDetails.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
	}
	
}
