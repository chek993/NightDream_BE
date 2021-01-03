package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "cliente")
    //
    //@JsonManagedReference
    //
    private List<Prenotazione> listaPrenotazioni;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Column(nullable = false)
    private String numTelefono;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}