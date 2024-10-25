package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOME DO USUÁRIO
    @Column(nullable = false)
    private String name;

    //EMAIL
    private String email;

    //FOTO DE PERFIL
    private String photo;

    //NÍVEL DE LEITURA
    private String readerLevel;


}
