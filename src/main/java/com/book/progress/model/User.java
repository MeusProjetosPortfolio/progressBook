package com.book.progress.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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

    //EMAIL DO USUÁRIO
    @Column(nullable = false, unique = true)
    private String email;

    //DATA DE ANIVERSÁRIO
    @Temporal(TemporalType.DATE)
    private Date birthday;

    //NÍVEL DE LEITURA
    private String readerLevel;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reading> readings;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Progress progress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Archievement> archievements;

}
