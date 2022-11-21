package com.epam.spring.library.controller;

import com.epam.spring.library.dto.ErrorDTO;
import com.epam.spring.library.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handlerEntityNotFoundException(EntityNotFoundException ex) {
        log.error("handlerEntityNotFoundException with message: {}", ex.getMessage(), ex);
        return ErrorDTO.builder().code(404).errorMessage(ex.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handlerEntityBadDataException(MethodArgumentNotValidException ex) {
        log.error("handlerEntityNotFoundException with message: {}", ex.getMessage(), ex);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return ErrorDTO.builder().code(404).errorMessage(errors.toString()).build();
    }

}
