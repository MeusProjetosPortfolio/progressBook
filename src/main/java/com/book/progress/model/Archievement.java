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

    //QUANTIDADE DE PONTOS PARA LIBERAR A CONQUISTA(EX: 50/100/150)
    private Integer points;

    //INDICAÇÃO SE É UMA CONQUISTA PREDEFINIDA OU CRIADA PELO USUÁRIO
    private boolean isCustom;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
