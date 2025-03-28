package com.products_DatabaseConnective.startUp.controller;

import com.products_DatabaseConnective.startUp.entity.Pedido;
import com.products_DatabaseConnective.startUp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        List<Pedido> pedidos = pedidoService.findALl();
        if(!pedidos.isEmpty())
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        else
            return new ResponseEntity<>(pedidos, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Integer id){
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null)
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoService.savePedido(pedido), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido){
        Pedido pedidoAtualizado = pedidoService.updatePedido(id, pedido);
        if (pedidoAtualizado != null)
            return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Boolean> deletePedido(@PathVariable Integer id){
        if (pedidoService.deletePedido(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
