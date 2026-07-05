package com.github.jadilson22a.estoqueapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErroGenerico.class)
    public ResponseEntity<RespostaErro> erroGenerico(ErroGenerico e){
        RespostaErro erro = new RespostaErro(
                e.getMessage(),
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(erro, HttpStatus.valueOf(erro.getStatusCode()));
    }

    //Intercepta todos os erros gerados pelo beanValidator do Spring boot
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaErro> erroValidação(MethodArgumentNotValidException e){
        List<CampoErro> camposErrados = new ArrayList<>();

        for(FieldError x: e.getFieldErrors()){
            camposErrados.add(new CampoErro(x.getField(), x.getDefaultMessage()));
        }

        RespostaErro erro = new RespostaErro(
                "Erro de validacao",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                camposErrados
        );

        return new ResponseEntity<>(erro, HttpStatus.valueOf(erro.getStatusCode()));
    }
}
