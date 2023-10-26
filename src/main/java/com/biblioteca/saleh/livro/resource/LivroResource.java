package com.biblioteca.saleh.livro.resource;

import com.biblioteca.saleh.livro.dto.LivroDTO;
import com.biblioteca.saleh.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/livros")
@RestController
public class LivroResource {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros(){
        return this.livroService.listarLivros();
    }
}
