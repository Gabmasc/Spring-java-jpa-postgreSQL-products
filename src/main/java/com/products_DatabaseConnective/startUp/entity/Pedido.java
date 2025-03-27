package com.products_DatabaseConnective.startUp.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer pedido_id;

    @Column(name = "pedido_data")
    private LocalTime pedido_data;

    @ManyToMany
    Set<Produto> produtos;

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public LocalTime getPedido_data() {
        return pedido_data;
    }

    public void setPedido_data(LocalTime pedido_data) {
        this.pedido_data = pedido_data;
    }
}
