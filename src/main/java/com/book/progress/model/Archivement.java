package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "archivements")
public class Archivement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOME DA CONQUISTA
    private String name;

    //DESCRIÇÃO DA CONQUISTA
    private String description;

    //QUANTIDADE DE PONTOS PARA LIBERAR A CONQUISTA(EX: 50/100/150)
    private Integer points;

    //DATA DO DESBLOQUEIO DA CONQUISTA
    @Temporal(TemporalType.DATE)
    private Date dateUnlocked;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
