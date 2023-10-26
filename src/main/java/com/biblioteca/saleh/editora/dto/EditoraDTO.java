package com.biblioteca.saleh.editora.dto;

import com.biblioteca.saleh.editora.model.Editora;

import java.util.List;
import java.util.stream.Collectors;

public record EditoraDTO(Long id, String nome) {
    public static EditoraDTO fromEditora(Editora editora){
        return new EditoraDTO(editora.getId(), editora.getNome());
    }

    public static List<EditoraDTO> converter(List<Editora> editoras){
        return editoras.stream().map(EditoraDTO::fromEditora).collect(Collectors.toList());
    }
}
