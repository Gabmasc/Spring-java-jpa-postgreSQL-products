package com.products_DatabaseConnective.startUp.controller;

import com.products_DatabaseConnective.startUp.entity.Categoria;
import com.products_DatabaseConnective.startUp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        List<Categoria> categorias = categoriaService.findAll();
        if(!categorias.isEmpty()){
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(categorias, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        if(categoria != null)
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Categoria>saveCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id,@RequestBody Categoria categoria){
        Categoria categoriaAtualizada = categoriaService.updateCategoria(id, categoria);
        if(categoriaAtualizada != null)
            return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id){
        if(categoriaService.deleteCategoria(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }


}
