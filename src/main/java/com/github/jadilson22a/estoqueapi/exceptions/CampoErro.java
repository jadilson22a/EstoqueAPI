package com.github.jadilson22a.estoqueapi.exceptions;

public class CampoErro {

    private String nomeCampo;
    private String menssagem;


    public CampoErro(String nomeCampo, String menssagem) {
        this.nomeCampo = nomeCampo;
        this.menssagem = menssagem;
    }


	public String getNomeCampo() {
		return nomeCampo;
	}


	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}


	public String getMenssagem() {
		return menssagem;
	}


	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
    
    
}
