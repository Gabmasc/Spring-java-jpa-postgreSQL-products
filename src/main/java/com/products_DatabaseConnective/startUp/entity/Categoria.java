package com.products_DatabaseConnective.startUp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer categoria_id;

    @Column(name = "categoria_nome")
    private String categoria_nome;

    

}
