package com.biblioteca.saleh.autor.dto;

import com.biblioteca.saleh.autor.model.Autor;

import java.util.List;
import java.util.stream.Collectors;


public record AutorDTO(Long id, String nome) {
    public static AutorDTO fromAutor(Autor autor) {
        return new AutorDTO(autor.getId(), autor.getNome());
    }

    public static List<AutorDTO> converter(List<Autor> autores){
        return autores.stream().map(AutorDTO::fromAutor).collect(Collectors.toList());
    }
}
