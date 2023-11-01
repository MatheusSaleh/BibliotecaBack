package com.biblioteca.saleh.livro.dto;

import com.biblioteca.saleh.autor.model.Autor;
import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.genero.model.Genero;
import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.pessoa.model.Pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record LivroDTO(Long id, String nome, Editora editora, Genero genero, Autor autor, Pessoa pessoaEmprestado, int quantidadeEmprestada, LocalDate dataDoUltimoEmprestimo, boolean disponivel) {

    public static LivroDTO fromLivro(Livro livro){
        return new LivroDTO(livro.getId(), livro.getNome(), livro.getEditora(), livro.getGenero(), livro.getAutor(), livro.getPessoaEmprestado(), livro.getQuantidadeEmprestada(), livro.getDataDoUltimoEmprestimo(), livro.isDisponivel());
    }

    public static List<LivroDTO> converter(List<Livro> livros){
        return livros.stream().map(LivroDTO::fromLivro).collect(Collectors.toList());
    }
}
