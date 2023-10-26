package com.biblioteca.saleh.livro.service;

import com.biblioteca.saleh.livro.dto.LivroDTO;
import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity<List<LivroDTO>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }
}
