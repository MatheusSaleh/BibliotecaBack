package com.biblioteca.saleh.autor.repository;

import com.biblioteca.saleh.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
