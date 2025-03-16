package com.exemplo.treinandoprova.desafio.repository;

import com.exemplo.treinandoprova.desafio.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository{
    private List<Cliente> clientes = new ArrayList<>(); //banco de dados em memória
    private Long nextID = 1L; // usado para gerar ids únicos para cada cliente

    // método que retorna a lista completa de clientes
    public  List<Cliente> findAll(){
        return clientes;
    }

    // método que pega o cliente pelo ID, ele retorna o método Optional cliente, ou seja, pode conter o cliente ou estar vazio
    public Optional<Cliente> findById(Long id){
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    // para salvar o cliente
    public  Cliente save(Cliente cliente){
        cliente.setId(nextID++);
        clientes.add(cliente);
        return cliente;
    }

   // findAll(): Retorna todos os clientes.
   // findById(Long id): Busca um cliente pelo ID.
}
