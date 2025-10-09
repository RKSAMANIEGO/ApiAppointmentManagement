package com.project.appointmentmangement.exceptions;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.*;

@RestControllerAdvice
public class ControllerException {

    private static final Logger log= LoggerFactory.getLogger(ControllerException.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
        log.error("Ocurred handler exception ", ex);
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception e){
        log.error("Ocurred exception ", e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR)  ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFound(EntityNotFoundException e){
        log.error("Ocurred exception ", e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND)  ,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalAccess(IllegalArgumentException e){
        log.error("Ocurred exception ", e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> accessDenied(AccessDeniedException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(e.getMessage(),HttpStatus.FORBIDDEN));
    }

}
