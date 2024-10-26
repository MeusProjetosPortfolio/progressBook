package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "readings")
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOTA EM RELAÇÃO À QUALIDADE DO LIVRO(1 à 5)
    private Integer rating;

    //PÁGINA ATUAL
    private Integer currentPage;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Progress progress;

}
