package com.biblioteca.saleh.autor.dto;

import com.biblioteca.saleh.autor.model.Autor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AutorDTO {
    private Long id;
    private String nome;

    public AutorDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
    }

    public static List<AutorDTO> converter(List<Autor> autores){
        return autores.stream().map(AutorDTO::new).collect(Collectors.toList());
    }
}
