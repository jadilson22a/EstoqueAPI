package com.github.jadilson22a.estoqueapi.Controller;

import com.github.jadilson22a.estoqueapi.entities.ProdutoDTO;
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
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable(value = "id") Integer id, @RequestBody @Valid ProdutoDTO dto){
        try{
            service.atualizar(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Integer id){
        try{
            service.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> buscarPorID(@PathParam("id") Integer id){
        try{
            return new ResponseEntity<>(service.buscarPorID(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarTudo(){
        try{
            return new ResponseEntity<>(service.buscarTudo(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
        }
    }
}
