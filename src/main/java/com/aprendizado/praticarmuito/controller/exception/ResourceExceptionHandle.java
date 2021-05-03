package com.aprendizado.praticarmuito.controller.exception;

import com.aprendizado.praticarmuito.service.exceptions.DataBaseException;
import com.aprendizado.praticarmuito.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

//criação da classe que intercepta os erro e impelementam as respostas

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StanderError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus  status= HttpStatus.NOT_FOUND;
        StanderError err = new StanderError(Instant.now(), status.value() , error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // tratamento em relação a caso especial de violação de integridade de banco de dados
    // por tentar excluir um user que contem dados de outras classes

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StanderError> database(DataBaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus  status= HttpStatus.BAD_REQUEST;
        StanderError err = new StanderError(Instant.now(), status.value() , error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
