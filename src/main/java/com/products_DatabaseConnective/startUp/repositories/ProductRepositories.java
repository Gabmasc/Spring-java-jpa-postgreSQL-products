package com.products_DatabaseConnective.startUp.repositories;

import com.products_DatabaseConnective.startUp.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepositories extends JpaRepository<ProductModel, UUID> {
}
