package com.biblioteca.saleh.genero.resource;

import com.biblioteca.saleh.genero.dto.GeneroDTO;
import com.biblioteca.saleh.genero.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
