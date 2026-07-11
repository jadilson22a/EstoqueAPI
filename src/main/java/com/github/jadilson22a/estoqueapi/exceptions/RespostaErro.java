package com.github.jadilson22a.estoqueapi.exceptions;

import java.time.LocalDateTime;
import java.util.List;


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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public List<CampoErro> getCamposErrados() {
		return camposErrados;
	}

	public void setCamposErrados(List<CampoErro> camposErrados) {
		this.camposErrados = camposErrados;
	}
    
    
}
