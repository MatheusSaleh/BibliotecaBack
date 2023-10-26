package com.biblioteca.saleh.pessoa.repository;

import com.biblioteca.saleh.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
