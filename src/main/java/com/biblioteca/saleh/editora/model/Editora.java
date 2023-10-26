package com.biblioteca.saleh.editora.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editora")
@Getter
@Setter
public class Editora {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editora")
    private Long id;

    private String nome;
}
