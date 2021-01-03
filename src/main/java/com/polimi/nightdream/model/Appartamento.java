package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Appartamento implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    //@NotNull
    private Proprietario proprietario;

    @OneToMany(mappedBy = "appartamento")
    //
    //@JsonManagedReference
    //
    private List<Prenotazione> listaPrenotazioni;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(name = "num_camere", nullable = false)
    private int numCamere;

    @Column(name = "num_bagni", nullable = false)
    private int numBagni;

    @Column(name = "posti_letto", nullable = false)
    private int postiLetto;

    @Column(nullable = false)
    private double prezzo;

    @Column(name = "bagno_camera")
    private boolean bagnoCamera;

    private boolean televisione, cucina;

}
