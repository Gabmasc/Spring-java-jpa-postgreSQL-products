package com.products_DatabaseConnective.startUp.repositories;

import com.products_DatabaseConnective.startUp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
