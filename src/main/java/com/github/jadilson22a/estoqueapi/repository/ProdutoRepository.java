package com.github.jadilson22a.estoqueapi.repository;

import com.github.jadilson22a.estoqueapi.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
