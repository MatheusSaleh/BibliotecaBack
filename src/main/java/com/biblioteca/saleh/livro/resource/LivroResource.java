package com.biblioteca.saleh.livro.resource;

import com.biblioteca.saleh.livro.dto.LivroCountDTO;
import com.biblioteca.saleh.livro.dto.LivroDTO;
import com.biblioteca.saleh.livro.form.LivroForm;
import com.biblioteca.saleh.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idLivro}")
    public ResponseEntity<LivroDTO> listarLivro(@PathVariable Long idLivro){
        return this.livroService.listarLivro(idLivro);
    }

    @GetMapping("/consulta-pivot")
    public ResponseEntity<List<LivroCountDTO>> consultarLivrosPorAutorEGenero(){
        List<LivroCountDTO> resultadoConsulta = livroService.consultarLivrosPorAutorEGenero();
        return new ResponseEntity<>(resultadoConsulta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody LivroForm formulario){
        return this.livroService.cadastrarLivro(formulario);
    }
}
