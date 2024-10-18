package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    //NÍVEL DE LEITURA
    private String readerLevel;


}
