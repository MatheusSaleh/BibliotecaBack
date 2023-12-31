package com.biblioteca.saleh.genero.service;

import com.biblioteca.saleh.exception.handler.ObjetoNaoEncontradoException;
import com.biblioteca.saleh.genero.dto.GeneroDTO;
import com.biblioteca.saleh.genero.form.GeneroForm;
import com.biblioteca.saleh.genero.model.Genero;
import com.biblioteca.saleh.genero.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public ResponseEntity<List<GeneroDTO>> listarGeneros(){
        List<Genero> generos = generoRepository.findAll();
        return ResponseEntity.ok(GeneroDTO.converter(generos));
    }

    public ResponseEntity<GeneroDTO> listarGenero(Long idGenero){
        Genero genero = this.buscarGenero(idGenero);
        return ResponseEntity.ok(GeneroDTO.fromGenero(genero));
    }

    public ResponseEntity<GeneroDTO> cadastrarGenero(GeneroForm formulario){
        Genero genero = new Genero();
        genero.setNome(formulario.getNome());
        genero = generoRepository.save(genero);
        return ResponseEntity.ok(GeneroDTO.fromGenero(genero));
    }

    public ResponseEntity<GeneroDTO> atualizarGenero(Long idGenero, GeneroForm formulario){
        Genero genero = this.buscarGenero(idGenero);
        genero.setNome(formulario.getNome());
        genero = generoRepository.save(genero);
        return ResponseEntity.ok(GeneroDTO.fromGenero(genero));
    }

    public ResponseEntity<Void> deleteGenero(Long idGenero){
        Genero genero = this.buscarGenero(idGenero);
        this.generoRepository.deleteById(idGenero);
        return ResponseEntity.ok().build();
    }

    public Genero buscarGenero(Long idGenero){
        Optional<Genero> optionalGenero = this.generoRepository.findById(idGenero);
        if(optionalGenero.isEmpty()){
            throw new ObjetoNaoEncontradoException("Genero com o id"+idGenero+" não encontrado");
        }
        return optionalGenero.get();
    }
}
