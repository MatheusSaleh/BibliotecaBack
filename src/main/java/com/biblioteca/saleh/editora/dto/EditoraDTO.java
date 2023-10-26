package com.biblioteca.saleh.editora.dto;

import com.biblioteca.saleh.editora.model.Editora;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class EditoraDTO {
    private Long id;
    private String nome;

    public EditoraDTO(Editora editora){
        this.id = editora.getId();
        this.nome = editora.getNome();
    }

    public static List<EditoraDTO> converter(List<Editora> editoras){
        return editoras.stream().map(EditoraDTO::new).collect(Collectors.toList());
    }
}
