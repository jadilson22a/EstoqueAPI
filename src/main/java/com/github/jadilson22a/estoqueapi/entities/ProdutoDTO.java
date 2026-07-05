package com.github.jadilson22a.estoqueapi.entities;

import com.github.jadilson22a.estoqueapi.models.Produto;

public record ProdutoDTO(Integer id, String nome, Double quantidade, UnidadeMedida unidadeMedida) {

    public Produto toProduto(){
        return new Produto(id, nome, quantidade, unidadeMedida);
    }
}
