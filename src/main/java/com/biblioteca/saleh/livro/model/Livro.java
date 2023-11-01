package com.biblioteca.saleh.livro.model;

import com.biblioteca.saleh.autor.model.Autor;
import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.genero.model.Genero;
import com.biblioteca.saleh.pessoa.model.Pessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "livro")
@Getter
@Setter
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoaEmprestado;

    private int quantidadeEmprestada;

    private LocalDate dataDoUltimoEmprestimo;

    private boolean disponivel;
}
