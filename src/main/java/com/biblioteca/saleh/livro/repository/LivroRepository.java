package com.biblioteca.saleh.livro.repository;

import com.biblioteca.saleh.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
