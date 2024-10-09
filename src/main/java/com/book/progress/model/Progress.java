package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //STATUS: LENDO/LIDO/ABANDONADO
    private String status;

    //QUANTIDADE DE LIVROS LIDOS
    private Integer booksRead;

    //PONTUAÇÃO TOTAL ACUMULADA
    private Integer totalPoints;

    //PORCENTAGEM DO PROGRESSO DE LEITURA DO LIVRO
    private Double averageReadingProgress;

    //QUANTIDADE DE CONQUISTAS DESBLOQUEADAS
    private Integer achievementsUnlocked;

    //QUANTIDADE DE DIAS PARA TERMINAR O LIVRO
    private Integer readingDurationInDays;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Reading> readings;



}
