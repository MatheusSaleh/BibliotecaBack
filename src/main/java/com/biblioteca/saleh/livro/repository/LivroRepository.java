package com.biblioteca.saleh.livro.repository;

import com.biblioteca.saleh.livro.dto.LivroCountDTO;
import com.biblioteca.saleh.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT NEW com.biblioteca.saleh.livro.dto.LivroCountDTO(a.nome, g.nome, COUNT(l)) " +
            "FROM Livro l " +
            "JOIN l.autor a " +
            "JOIN l.genero g " +
            "GROUP BY a.nome, g.nome")
    List<LivroCountDTO> consultaAgrupamento();

    List<Livro> findByDisponivelTrue();
}
