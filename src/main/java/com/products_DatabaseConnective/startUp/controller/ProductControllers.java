package com.products_DatabaseConnective.startUp.controller;

import com.products_DatabaseConnective.startUp.entity.ProductModel;
import com.products_DatabaseConnective.startUp.productRecordsDTO.ProductDTO;
import com.products_DatabaseConnective.startUp.repositories.ProductRepositories;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductControllers {

    @Autowired
    ProductRepositories productRepositories;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepositories.save(productModel));
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> productList = productRepositories.findAll();
        if(!productList.isEmpty()){
            for(ProductModel product : productList){
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductControllers.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productO = productRepositories.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productO.get().add(linkTo(methodOn(ProductControllers.class).getAllProducts()).withRel("Products List"));
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ProductDTO productDTO) {
        Optional<ProductModel> productO = productRepositories.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(productDTO, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepositories.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productO = productRepositories.findById(id);
        if (productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        productRepositories.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}