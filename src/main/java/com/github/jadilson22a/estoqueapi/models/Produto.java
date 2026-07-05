package com.github.jadilson22a.estoqueapi.models;

import com.github.jadilson22a.estoqueapi.entities.ProdutoDTO;
import com.github.jadilson22a.estoqueapi.entities.UnidadeMedida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @Column(name = "unidade_medida")
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double quantidade, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public ProdutoDTO toDTO(){
        return new ProdutoDTO(id, nome, quantidade, unidadeMedida);
    }
}
