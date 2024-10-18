package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "archievements")
public class Archievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOME DA CONQUISTA
    private String name;

    //DESCRIÇÃO DA CONQUISTA
    private String description;

    //QUANTIDADE DE PONTOS PARA LIBERAR A CONQUISTA(EX: 50/100/150) livro
    private Integer points;
}
