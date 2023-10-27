package com.biblioteca.saleh.editora.resource;

import com.biblioteca.saleh.editora.dto.EditoraDTO;
import com.biblioteca.saleh.editora.form.EditoraForm;
import com.biblioteca.saleh.editora.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idEditora}")
    public ResponseEntity<EditoraDTO> listarEditora(@PathVariable Long idEditora){
        return this.editoraService.listarEditora(idEditora);
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> cadastrarEditora(@RequestBody EditoraForm formulario){
        return this.editoraService.cadastrarEditora(formulario);
    }
}
