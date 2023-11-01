package com.biblioteca.saleh.transacao.dto;

import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.transacao.enums.TipoTransacao;
import com.biblioteca.saleh.transacao.model.Transacao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record TransacaoDTO(Long id, LocalDate data, TipoTransacao tipo, Livro livro) {
    public static TransacaoDTO fromTransacao(Transacao transacao){
        return new TransacaoDTO(transacao.getId(), transacao.getData(), transacao.getTipo(), transacao.getLivro());
    }

    public static List<TransacaoDTO> converter(List<Transacao> transacao){
        return transacao.stream().map(TransacaoDTO::fromTransacao).collect(Collectors.toList());
    }
}
