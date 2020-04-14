package br.com.calendario.apieventos.error.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.calendario.apieventos.error.ResponseError;
import br.com.calendario.apieventos.error.exception.ObjectNotFoundException;

@ControllerAdvice
public class RestExcepionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { ObjectNotFoundException.class })
    protected ResponseEntity<Object> objectNotFoundExceptionHandler(ObjectNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ResponseError(ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
	 
	@ExceptionHandler(value = { AuthenticationException.class })
    protected ResponseEntity<Object> authenticationExceptionHandler(AuthenticationException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Erro de autenticação.", new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
