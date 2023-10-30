package com.biblioteca.saleh.editora.service;

import com.biblioteca.saleh.editora.dto.EditoraDTO;
import com.biblioteca.saleh.editora.form.EditoraForm;
import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.editora.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    @Autowired
    EditoraRepository editoraRepository;

    public ResponseEntity<List<EditoraDTO>> listarEditoras(){
        List<Editora> editoras = editoraRepository.findAll();
        return ResponseEntity.ok(EditoraDTO.converter(editoras));
    }

    public ResponseEntity<EditoraDTO> listarEditora(Long idEditora){
        Editora editora = this.buscarEditora(idEditora);
        return ResponseEntity.ok(EditoraDTO.fromEditora(editora));
    }

    public ResponseEntity<EditoraDTO> cadastrarEditora(EditoraForm formulario){
        Editora editora = new Editora();
        editora.setNome(formulario.getNome());
        editora = editoraRepository.save(editora);
        return ResponseEntity.ok(EditoraDTO.fromEditora(editora));
    }

    public ResponseEntity<EditoraDTO> atualizarEditora(Long idEditora, EditoraForm formulario){
        Editora editora = this.buscarEditora(idEditora);
        editora.setNome(formulario.getNome());
        editora = editoraRepository.save(editora);
        return ResponseEntity.ok(EditoraDTO.fromEditora(editora));
    }

    public ResponseEntity<EditoraDTO> deleteEditora(Long idEditora){
        Editora editora = this.buscarEditora(idEditora);
        this.editoraRepository.deleteById(editora.getId());
        return ResponseEntity.ok().build();
    }

    public Editora buscarEditora(Long idEditora){
        Optional<Editora> optionalEditora = this.editoraRepository.findById(idEditora);
        return optionalEditora.get();
    }
}
