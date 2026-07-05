package com.github.jadilson22a.estoqueapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoErro {

    private String nomeCampo;
    private String menssagem;


    public CampoErro(String nomeCampo, String menssagem) {
        this.nomeCampo = nomeCampo;
        this.menssagem = menssagem;
    }
}
