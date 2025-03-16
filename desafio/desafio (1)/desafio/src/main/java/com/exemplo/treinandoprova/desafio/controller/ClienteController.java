package com.exemplo.treinandoprova.desafio.controller;

import com.exemplo.treinandoprova.desafio.model.Cliente;
import com.exemplo.treinandoprova.desafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    // pegar por id
    @GetMapping("/{id}")
    public Cliente listarClientes (@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);

    }
}
