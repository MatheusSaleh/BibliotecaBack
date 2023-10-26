package com.biblioteca.saleh.pessoa.service;

import com.biblioteca.saleh.pessoa.dto.PessoaDTO;
import com.biblioteca.saleh.pessoa.model.Pessoa;
import com.biblioteca.saleh.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public ResponseEntity<List<PessoaDTO>> listarPessoas(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(PessoaDTO.converter(pessoas));
    }
}
