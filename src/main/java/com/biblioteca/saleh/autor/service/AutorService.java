package com.biblioteca.saleh.autor.service;

import com.biblioteca.saleh.autor.dto.AutorDTO;
import com.biblioteca.saleh.autor.model.Autor;
import com.biblioteca.saleh.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public ResponseEntity<List<AutorDTO>> listarAutores(){
        List<Autor> autores = autorRepository.findAll();
        return ResponseEntity.ok(AutorDTO.converter(autores));
    }
}
