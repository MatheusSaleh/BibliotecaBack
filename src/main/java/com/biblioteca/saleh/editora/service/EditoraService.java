package com.biblioteca.saleh.editora.service;

import com.biblioteca.saleh.editora.dto.EditoraDTO;
import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.editora.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    @Autowired
    EditoraRepository editoraRepository;

    public ResponseEntity<List<EditoraDTO>> listarEditoras(){
        List<Editora> editoras = editoraRepository.findAll();
        return ResponseEntity.ok(EditoraDTO.converter(editoras));
    }
}
