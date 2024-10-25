package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //STATUS: LENDO/LIDO/ABANDONADO
    @Column(nullable = false)
    private String status;

    //PÁGINA ATUAL
    private Integer currentPage;

    //DATA DE INÍCIO
    @Temporal(TemporalType.DATE)
    private Date startDate;

    //DATA DE TÉRMINO
    @Temporal(TemporalType.DATE)
    private Date endDate;

    //PORCENTAGEM DO PROGRESSO DE LEITURA DO LIVRO
    private Double averageReadingProgress;

    //QUANTIDADE DE DIAS QUE DEMOREI PARA LER
    private Integer readingDurationInDays;

}
