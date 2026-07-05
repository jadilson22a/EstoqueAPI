package com.github.jadilson22a.estoqueapi.Controller;

import com.github.jadilson22a.estoqueapi.entities.ProdutoDTO;
import com.github.jadilson22a.estoqueapi.exceptions.ErroGenerico;
import com.github.jadilson22a.estoqueapi.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid ProdutoDTO dto){
        try {
            service.salvar(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (ErroGenerico e) {
            throw new ErroGenerico(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Integer id, @RequestBody @Valid ProdutoDTO dto){
        try{
            service.atualizar(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (ErroGenerico e) {
            throw new ErroGenerico(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        try{
            service.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (ErroGenerico e) {
            throw new ErroGenerico(e.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> buscarPorID(@PathParam("id") Integer id){
        try{
            return new ResponseEntity<>(service.buscarPorID(id), HttpStatus.OK);
        }catch (ErroGenerico e) {
            throw new ErroGenerico(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarTudo(){
        try{
            return new ResponseEntity<>(service.buscarTudo(), HttpStatus.OK);
        }catch (ErroGenerico e) {
            throw new ErroGenerico(e.getMessage());
        }
    }
}
