package com.biblioteca.saleh.autor.resource;

import com.biblioteca.saleh.autor.dto.AutorDTO;
import com.biblioteca.saleh.autor.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
