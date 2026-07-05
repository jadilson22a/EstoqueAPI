package com.github.jadilson22a.estoqueapi.service;

import com.github.jadilson22a.estoqueapi.entities.ProdutoDTO;
import com.github.jadilson22a.estoqueapi.models.Produto;
import com.github.jadilson22a.estoqueapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvar(ProdutoDTO dto){
        Produto produto = dto.toProduto();
        repository.save(produto);
    }

    public void atualizar(Integer id, ProdutoDTO dto){
        Produto produto = dto.toProduto();
        produto.setId(id);
        repository.save(produto);
    }

    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public ProdutoDTO buscarPorID(Integer id){
        Produto produto = repository.findById(id).orElse(null);
        return new ProdutoDTO(
                id,
                produto.getNome(),
                produto.getQuantidade(),
                produto.getUnidadeMedida()
        );
    }

    public List<ProdutoDTO> buscarTudo(){
        return repository.findAll()
                .stream()
                .map(Produto::toDTO).toList();
    }
}
