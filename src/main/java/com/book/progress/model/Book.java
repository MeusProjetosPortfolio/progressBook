package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TÍTULO DA OBRA
    @Column(nullable = false)
    private String title;

    //AUTOR DA OBRA
    @Column(nullable = false)
    private String author;

    //GÊNERO DA OBRA
    private String genre;

    //TOTAL DE PÁGINAS DO LIVRO
    @Column(nullable = false)
    private Integer totalPages;
}
