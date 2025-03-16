package com.exemplo.treinandoprova.desafio.repository;

import com.exemplo.treinandoprova.desafio.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private Long nextId = 1L;
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> findAll(){
        return produtos;
    }

    public Optional<Produto> findById(Long id){
        return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst();
    }

    public Produto save(Produto produto){
        produto.setId(nextId++);
        produtos.add(produto);
        return produto;
    }
}
