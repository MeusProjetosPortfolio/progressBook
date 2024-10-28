package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


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

    //DATA DE INÍCIO
    @Temporal(TemporalType.DATE)
    private Date startDate;

    //DATA DE TÉRMINO
    @Temporal(TemporalType.DATE)
    private Date endDate;

    // NOTA DO PROGRESSO
    @Column(length = 500)
    private String progressNote;
}
