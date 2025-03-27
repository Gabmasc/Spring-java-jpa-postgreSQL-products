package com.products_DatabaseConnective.startUp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "categoria")
    @JsonBackReference
    private List<Produto> produto_List;

    public List<Produto> getProduto_List() {
        return produto_List;
    }

    public void setProduto_List(List<Produto> produto_List) {
        this.produto_List = produto_List;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }
}
