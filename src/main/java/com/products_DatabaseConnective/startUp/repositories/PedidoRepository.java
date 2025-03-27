package com.products_DatabaseConnective.startUp.repositories;

import com.products_DatabaseConnective.startUp.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
