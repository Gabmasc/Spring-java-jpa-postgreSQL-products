package com.products_DatabaseConnective.startUp.service;

import com.products_DatabaseConnective.startUp.entity.Pedido;
import com.products_DatabaseConnective.startUp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> findALl(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido){
        Pedido pedidoAtualizado = pedidoRepository.findById(id).orElse(null);
        if(pedidoAtualizado != null){
            pedidoAtualizado.setPedido_data(pedido.getPedido_data());
            return pedidoRepository.save(pedidoAtualizado);
        }else {
            return null;
        }
    }

    public boolean deletePedido(Integer id){
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if(pedido != null) {
            pedidoRepository.delete(pedido);
            return true;
        } else {
            return false;
        }
    }
}
