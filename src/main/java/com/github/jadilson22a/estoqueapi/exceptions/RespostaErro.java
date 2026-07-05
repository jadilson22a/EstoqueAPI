package com.github.jadilson22a.estoqueapi.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RespostaErro {
    private String mensagem;
    private int statusCode;
    private LocalDateTime momento;
    private List<CampoErro> camposErrados;

    public RespostaErro(String mensagem, int statusCode, LocalDateTime momento) {
        this.mensagem = mensagem;
        this.statusCode = statusCode;
        this.momento = momento;
    }

    public RespostaErro(String mensagem, int statusCode, LocalDateTime momento, List<CampoErro> camposErrados) {
        this.mensagem = mensagem;
        this.statusCode = statusCode;
        this.momento = momento;
        this.camposErrados = camposErrados;
    }
}
