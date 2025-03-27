package com.products_DatabaseConnective.startUp.repositories;

import com.products_DatabaseConnective.startUp.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
