package com.products_DatabaseConnective.startUp.service;

import com.products_DatabaseConnective.startUp.entity.Categoria;
import com.products_DatabaseConnective.startUp.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Integer id, Categoria categoria){
        Categoria categoriaAtualizada = categoriaRepository.findById(id).orElse(null);
        if(categoriaAtualizada != null){
            categoriaAtualizada.setCategoria_nome(categoria.getCategoria_nome());
            return categoriaRepository.save(categoriaAtualizada);
        }else {
            return null;
        }
    }

    public boolean deleteCategoria(Integer id){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria != null){
            categoriaRepository.delete(categoria);
            return true;
        }else {
            return false;
        }
    }

}
