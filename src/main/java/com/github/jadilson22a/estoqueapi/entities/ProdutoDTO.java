package com.github.jadilson22a.estoqueapi.entities;

import com.github.jadilson22a.estoqueapi.models.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoDTO(
        Integer id,

        @NotBlank(message = "nome é obrigatorio")
        String nome,

        @PositiveOrZero(message = "O numero precisa ser positivo ou zero")
        Double quantidade,

        @NotBlank(message = "unidade de medida é obrigatorio")
        UnidadeMedida unidadeMedida) {

    public Produto toProduto(){
        return new Produto(id, nome, quantidade, unidadeMedida);
    }
}
