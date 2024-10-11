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

    //STATUS: LENDO/LIDO/ABANDONADO OK
    private String status;

    //PORCENTAGEM DO PROGRESSO DE LEITURA DO LIVRO OK
    private Double averageReadingProgress;

    //QUANTIDADE DE DIAS QUE DEMOREI PARA LER OK
    private Integer readingDurationInDays;

    @OneToOne
    private Reading reading;



}
