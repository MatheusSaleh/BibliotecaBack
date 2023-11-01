package com.biblioteca.saleh.livro.form;

import com.biblioteca.saleh.autor.model.Autor;
import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.genero.model.Genero;
import com.biblioteca.saleh.pessoa.model.Pessoa;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LivroForm {
    private String nome;

    private Editora editora;

    private Genero genero;

    private Autor autor;

    private Pessoa pessoaEmprestado;

    private int quantidadeEmprestada;

    private LocalDate dataDoUltimoEmprestimo;

    private boolean disponivel;
}
