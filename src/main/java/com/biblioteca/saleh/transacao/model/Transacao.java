package com.biblioteca.saleh.transacao.model;

import com.biblioteca.saleh.livro.model.Livro;
import com.biblioteca.saleh.transacao.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "transacao")
@Getter
@Setter
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    private TipoTransacao tipo;

    @ManyToOne
    private Livro livro;
}
