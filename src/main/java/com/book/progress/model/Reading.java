package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "readings")
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //PÁGINAS ATUAL
    private Integer currentPage;

    //DATA DE INÍCIO
    @Temporal(TemporalType.DATE)
    private Date startDate;

    //DATA DE TÉRMINO
    @Temporal(TemporalType.DATE)
    private Date endDate;

    //NOTA EM RELAÇÃO À QUALIDADE DO LIVRO(1 à 5)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;



}
