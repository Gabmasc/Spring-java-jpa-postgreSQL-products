package com.products_DatabaseConnective.startUp.service;

import com.products_DatabaseConnective.startUp.entity.Produto;
import com.products_DatabaseConnective.startUp.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto udpdateProduto(Integer id, Produto produto){
        Produto produtoAtualizado = produtoRepository.findById(id).orElse(null);
        if( produtoAtualizado != null){
            produtoAtualizado.setProduto_nome(produto.getProduto_nome());
            return produtoRepository.save(produtoAtualizado);
        }else {
            return null;
        }
    }

    public boolean delete(Integer id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if(produto != null){
            produtoRepository.delete(produto);
            return true;
        }else {
            return false;
        }
    }
}
