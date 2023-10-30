package com.biblioteca.saleh.autor.resource;

import com.biblioteca.saleh.autor.dto.AutorDTO;
import com.biblioteca.saleh.autor.form.AutorForm;
import com.biblioteca.saleh.autor.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/autores")
@RestController
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> listarAutores(){
        return this.autorService.listarAutores();
    }

    @GetMapping("/{idAutor}")
    public ResponseEntity<AutorDTO> listarAutor(@PathVariable Long idAutor){
        return this.autorService.listarAutor(idAutor);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody AutorForm formulario){
        return this.autorService.cadastrarAutor(formulario);
    }

    @PutMapping("/{idAutor}")
    public ResponseEntity<AutorDTO> atualizarAutor(@PathVariable Long idAutor, @RequestBody AutorForm formulario){
        return this.autorService.atualizarAutor(idAutor, formulario);
    }

    @DeleteMapping("/{idAutor}")
    public ResponseEntity<AutorDTO> deletarAutor(@PathVariable Long idAutor){
        return this.autorService.deleteAutor(idAutor);
    }
}
