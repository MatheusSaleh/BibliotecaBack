package com.biblioteca.saleh.genero.service;

import com.biblioteca.saleh.genero.dto.GeneroDTO;
import com.biblioteca.saleh.genero.model.Genero;
import com.biblioteca.saleh.genero.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public ResponseEntity<List<GeneroDTO>> listarGeneros(){
        List<Genero> generos = generoRepository.findAll();
        return ResponseEntity.ok(GeneroDTO.converter(generos));
    }
}
