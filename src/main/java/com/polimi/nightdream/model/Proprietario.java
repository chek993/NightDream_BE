package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proprietario implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "proprietario")
    @JsonManagedReference
    @JsonIgnore
    private List<Appartamento> listaAppartamenti;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    private String numTelefono;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Proprietario(){}

    public Proprietario(String nome, String cognome, LocalDate dataNascita, String numTelefono, String email, String password) {
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

    public List<Appartamento> getListaAppartamenti() {
        return listaAppartamenti;
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

    public void setListaAppartamenti(List<Appartamento> listaAppartamenti) {
        this.listaAppartamenti = listaAppartamenti;
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

        Proprietario proprietario = (Proprietario) o;

        return new EqualsBuilder()
                .append(nome, proprietario.nome)
                .append(cognome, proprietario.cognome)
                .append(dataNascita, proprietario.dataNascita)
                .append(numTelefono, proprietario.numTelefono)
                .append(email, proprietario.email)
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
