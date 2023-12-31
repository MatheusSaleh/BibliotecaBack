package com.biblioteca.saleh.autor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autor")
@Getter
@Setter
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long id;

    private String nome;
}
