package com.biblioteca.saleh.pessoa.dto;

import com.biblioteca.saleh.pessoa.model.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public record PessoaDTO(Long id, String nome, String endereco) {

    public static PessoaDTO fromPessoa(Pessoa pessoa){
        return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEndereco());
    }

    public static List<PessoaDTO> converter(List<Pessoa> pessoas){
        return pessoas.stream().map(PessoaDTO::fromPessoa).collect(Collectors.toList());
    }
}
