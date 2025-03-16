package com.exemplo.treinandoprova.exercicio1.controller;

import com.exemplo.treinandoprova.exercicio1.model.Livro;
import com.exemplo.treinandoprova.exercicio1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired //injeção de dependência de forma automatica
    private LivroRepository livroRepository; // criando o repository

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        Livro livroCadastrado = livroRepository.save(livro);
        return ResponseEntity.status(201).body(livroCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.status(200).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Integer id, @RequestBody Livro livro){
        return ResponseEntity.of(livroRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Integer id, @RequestBody Livro livro){
        if(livroRepository.existsById(id)){
            livro.setId(id);
            return ResponseEntity.ok(livroRepository.save(livro));
        }
        return ResponseEntity.notFound().build(); // not Found  (um objeto com 404 ) .build() finaliza a construção da resposta sem adicionar um corpo body
      // Quando o recurso solicitado não existe no servidor.
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(livroRepository.existsById(id)){
            livroRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
