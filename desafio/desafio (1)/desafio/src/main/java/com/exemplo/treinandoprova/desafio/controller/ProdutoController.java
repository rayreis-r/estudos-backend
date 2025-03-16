package com.exemplo.treinandoprova.desafio.controller;

import com.exemplo.treinandoprova.desafio.model.Produto;
import com.exemplo.treinandoprova.desafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto listarPorId (@PathVariable Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
       return produtoRepository.save(produto);
    }

}
