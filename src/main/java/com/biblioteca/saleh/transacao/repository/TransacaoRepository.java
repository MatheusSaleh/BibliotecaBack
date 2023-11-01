package com.biblioteca.saleh.transacao.repository;

import com.biblioteca.saleh.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
