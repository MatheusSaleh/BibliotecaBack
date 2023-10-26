package com.biblioteca.saleh.livro.model;

import com.biblioteca.saleh.editora.model.Editora;
import com.biblioteca.saleh.genero.model.Genero;
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

    private int quantidadeEmprestada;

    private LocalDate dataDoUltimoEmprestimo;
}
