package com.products_DatabaseConnective.startUp.controller;

import com.products_DatabaseConnective.startUp.models.ProductModel;
import com.products_DatabaseConnective.startUp.productRecordsDTO.ProductDTO;
import com.products_DatabaseConnective.startUp.repositories.ProductRepositories;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllers {

    @Autowired
    ProductRepositories productRepositories;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepositories.save(productModel));
    }

}
