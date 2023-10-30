package com.biblioteca.saleh.genero.resource;

import com.biblioteca.saleh.genero.dto.GeneroDTO;
import com.biblioteca.saleh.genero.form.GeneroForm;
import com.biblioteca.saleh.genero.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/generos")
@RestController
public class GeneroResource {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> listarGeneros(){
        return this.generoService.listarGeneros();
    }

    @GetMapping("/{idGenero}")
    public ResponseEntity<GeneroDTO> listarGenero(@PathVariable Long idGenero){
        return this.generoService.listarGenero(idGenero);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> cadastrarGenero(@RequestBody GeneroForm formulario){
        return this.generoService.cadastrarGenero(formulario);
    }

    @PutMapping("/{idGenero}")
    public ResponseEntity<GeneroDTO> atualizarGenero(@PathVariable Long idGenero, GeneroForm formulario){
        return this.generoService.atualizarGenero(idGenero, formulario);
    }

    @DeleteMapping("/{idGenero}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long idGenero){
        return this.generoService.deleteGenero(idGenero);
    }
}
