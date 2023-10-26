package com.biblioteca.saleh.genero.dto;

import com.biblioteca.saleh.genero.model.Genero;

import java.util.List;
import java.util.stream.Collectors;

public record GeneroDTO(Long id, String nome) {

    public static GeneroDTO fromGenero(Genero genero){
        return new GeneroDTO(genero.getId(), genero.getNome());
    }

    public static List<GeneroDTO> converter(List<Genero> generos){
        return generos.stream().map(GeneroDTO::fromGenero).collect(Collectors.toList());
    }
}
