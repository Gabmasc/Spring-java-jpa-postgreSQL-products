package com.products_DatabaseConnective.startUp.controller;

import com.products_DatabaseConnective.startUp.entity.Produto;
import com.products_DatabaseConnective.startUp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = produtoService.findAll();
        if(!produtos.isEmpty())
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        else
            return new ResponseEntity<>(produtos, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Integer id){
        Produto produto = produtoService.findById(id);
        if(produto != null )
            return new ResponseEntity<>(produto, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoService.saveProduto(produto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.udpdateProduto(id, produto);
        if(produtoAtualizado != null)
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduto(@PathVariable Integer id){
        if(produtoService.delete(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
 }
