package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    @JsonIgnore
    private List<Prenotazione> listaPrenotazioni;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(name = "data_nascita",nullable = false)
    private LocalDate dataNascita;

    @Column(nullable = false)
    private String numTelefono;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Cliente(){}

    public Cliente(String nome, String cognome, LocalDate dataNascita, String numTelefono, String email, String password) {
        this.listaPrenotazioni = new ArrayList<>();
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numTelefono = numTelefono;
        this.email = email;
        this.password = password;
    }

    //Getter

    public Integer getId() {
        return id;
    }

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //Setter


    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataDiNascita) {
        this.dataNascita = dataDiNascita;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return new EqualsBuilder()
                .append(nome, cliente.nome)
                .append(cognome, cliente.cognome)
                .append(dataNascita, cliente.dataNascita)
                .append(numTelefono, cliente.numTelefono)
                .append(email, cliente.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(cognome)
                .append(dataNascita)
                .append(numTelefono)
                .append(email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id = " + id +
                ", nome = '" + nome +
                "\', cognome = " + cognome +
                ", data_di_nascita = " + dataNascita.toString() +
                ", num_telefono = " + numTelefono +
                ", email = " + email + "}";
    }
}
