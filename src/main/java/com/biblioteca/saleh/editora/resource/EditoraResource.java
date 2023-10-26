package com.biblioteca.saleh.editora.resource;

import com.biblioteca.saleh.editora.dto.EditoraDTO;
import com.biblioteca.saleh.editora.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/editoras")
@RestController
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> listarEditoras(){
        return this.editoraService.listarEditoras();
    }
}
