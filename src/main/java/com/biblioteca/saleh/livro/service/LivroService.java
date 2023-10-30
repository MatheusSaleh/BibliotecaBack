package com.biblioteca.saleh.livro.service;

import com.biblioteca.saleh.livro.dto.LivroCountDTO;
import com.biblioteca.saleh.livro.dto.LivroDTO;
import com.biblioteca.saleh.livro.form.LivroForm;
import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity<List<LivroDTO>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }

    public ResponseEntity<LivroDTO> listarLivro(Long idLivro){
        Livro livro = this.buscarLivro(idLivro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<LivroDTO> cadastrarLivro(LivroForm formulario){
        Livro livro = new Livro();
        livro.setNome(formulario.getNome());
        livro.setEditora(formulario.getEditora());
        livro.setGenero(formulario.getGenero());
        livro.setAutor(formulario.getAutor());
        livro.setPessoaEmprestado(formulario.getPessoaEmprestado());
        livro.setQuantidadeEmprestada(formulario.getQuantidadeEmprestada());
        livro.setDataDoUltimoEmprestimo(formulario.getDataDoUltimoEmprestimo());
        livro = livroRepository.save(livro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public List<LivroCountDTO> consultarLivrosPorAutorEGenero(){
        return livroRepository.consultaPivot();
    }

    public ResponseEntity<LivroDTO> atualizarLivro(Long idLivro, LivroForm formulario){
        Livro livro = this.buscarLivro(idLivro);
        livro.setNome(formulario.getNome());
        livro.setEditora(formulario.getEditora());
        livro.setGenero(formulario.getGenero());
        livro.setAutor(formulario.getAutor());
        livro.setPessoaEmprestado(formulario.getPessoaEmprestado());
        livro.setQuantidadeEmprestada(formulario.getQuantidadeEmprestada());
        livro.setDataDoUltimoEmprestimo(formulario.getDataDoUltimoEmprestimo());
        livro = livroRepository.save(livro);
        return ResponseEntity.ok(LivroDTO.fromLivro(livro));
    }

    public ResponseEntity<Void> deleteLivro(Long idLivro){
        Livro livro = this.buscarLivro(idLivro);
        this.livroRepository.deleteById(livro.getId());
        return ResponseEntity.ok().build();
    }

    public Livro buscarLivro(Long idLivro){
        Optional<Livro> optionalLivro = this.livroRepository.findById(idLivro);
        return optionalLivro.get();
    }
}
