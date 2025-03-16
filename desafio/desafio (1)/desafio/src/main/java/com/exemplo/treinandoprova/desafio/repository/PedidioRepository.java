package com.exemplo.treinandoprova.desafio.repository;

import com.exemplo.treinandoprova.desafio.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidioRepository {
    private List<Pedido> pedidos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Pedido> findAll(){
        return pedidos;
    }

    public Optional<Pedido> findById (Long id){
        return pedidos.stream().filter(pedido -> pedido.getId().equals(id)).findFirst();
    }

    public Pedido save(Pedido pedido){
        pedido.setId(nextId ++);
        pedidos.add(pedido);
        return pedido;
    }



}
