package com.exemplo.treinandoprova.desafio.controller;

import com.exemplo.treinandoprova.desafio.model.Cliente;
import com.exemplo.treinandoprova.desafio.model.Pedido;
import com.exemplo.treinandoprova.desafio.repository.PedidioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidioRepository pedidioRepository;

    @GetMapping
    public List<Pedido> listar(){
        return pedidioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido listarPorId(@PathVariable Long id){
        return pedidioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido cadastrar (@RequestBody Pedido pedido){
        return pedidioRepository.save(pedido);
    }
}
