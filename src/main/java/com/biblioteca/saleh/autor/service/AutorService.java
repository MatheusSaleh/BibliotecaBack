package com.biblioteca.saleh.autor.service;

import com.biblioteca.saleh.autor.dto.AutorDTO;
import com.biblioteca.saleh.autor.form.AutorForm;
import com.biblioteca.saleh.autor.model.Autor;
import com.biblioteca.saleh.autor.repository.AutorRepository;
import com.biblioteca.saleh.exception.handler.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public ResponseEntity<List<AutorDTO>> listarAutores(){
        List<Autor> autores = autorRepository.findAll();
        return ResponseEntity.ok(AutorDTO.converter(autores));
    }

    public ResponseEntity<AutorDTO> listarAutor(Long idAutor){
        Autor autor = this.buscarAutor(idAutor);
        return ResponseEntity.ok(AutorDTO.fromAutor(autor));
    }

    public ResponseEntity<AutorDTO> cadastrarAutor(AutorForm formulario){
        Autor autor = new Autor();
        autor.setNome(formulario.getNome());
        autor = autorRepository.save(autor);
        return ResponseEntity.ok(AutorDTO.fromAutor(autor));
    }

    public ResponseEntity<AutorDTO> atualizarAutor(Long idAutor, AutorForm formulario){
        Autor autor = this.buscarAutor(idAutor);
        autor.setNome(formulario.getNome());
        autor = autorRepository.save(autor);
        return ResponseEntity.ok(AutorDTO.fromAutor(autor));
    }

    public ResponseEntity<AutorDTO> deleteAutor(Long idAutor){
        Autor autor = this.buscarAutor(idAutor);
        this.autorRepository.deleteById(autor.getId());
        return ResponseEntity.ok().build();
    }

    public Autor buscarAutor(Long idAutor){
        Optional<Autor> optionalAutor = this.autorRepository.findById(idAutor);
        if(optionalAutor.isEmpty()){
            throw new ObjetoNaoEncontradoException("Autor com o id"+idAutor+" não encontrado");
        }
        return optionalAutor.get();
    }


}
