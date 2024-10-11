package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private User user;

    @ManyToOne
    private Book book;

    @OneToOne(mappedBy = "reading", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Progress progress;






}
