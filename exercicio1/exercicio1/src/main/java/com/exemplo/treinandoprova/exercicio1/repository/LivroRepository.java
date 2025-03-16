package com.exemplo.treinandoprova.exercicio1.repository;

import com.exemplo.treinandoprova.exercicio1.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
