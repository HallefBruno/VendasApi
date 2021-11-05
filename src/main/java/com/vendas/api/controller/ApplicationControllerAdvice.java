package com.vendas.api.controller;

import com.vendas.api.exception.dto.ApiErrors;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectErro -> objectErro.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException ex) {
        String messageError = ex.getReason();
        HttpStatus status = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(messageError);
        return new ResponseEntity<>(apiErrors, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> internalError(Exception ex) {
        String messageError = ((DataIntegrityViolationException) ex).getMostSpecificCause().getMessage();
        if(messageError.contains("duplicate key")) {
            messageError = "Esse registro já está cadastrado!";
        }
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiErrors apiErrors = new ApiErrors(messageError);
        return new ResponseEntity<>(apiErrors, status);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String msg = String.format("O parâmetro '%s' do valor '%s' não pôde ser convertido para o tipo '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());
        ApiErrors apiError = new ApiErrors(msg);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(apiError, status);
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ApiErrors handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        return new ApiErrors("Recurso não encontrado");
    }

}

