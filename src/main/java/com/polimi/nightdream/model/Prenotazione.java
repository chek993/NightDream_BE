package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prenotazione implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @NotNull
    private Appartamento appartamento;

    @Column(nullable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private LocalDate dataInizio;

    @Column(nullable = false)
    private LocalDate dataFine;

    private boolean pagato;

    private String metodoPagamento;

    public Prenotazione(){}

    public Prenotazione(Cliente cliente, Appartamento appartamento, LocalDate dataInizio, LocalDate dataFine, boolean pagato, String metodoPagamento) {
        this.creationTime = LocalDateTime.now();
        this.cliente = cliente;
        this.appartamento = appartamento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.pagato = pagato;
        this.metodoPagamento = metodoPagamento;
    }

    //Getter

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Appartamento getAppartamento() {
        return appartamento;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public boolean isPagato() {
        return pagato;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }


    //Setter


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAppartamento(Appartamento appartamento) {
        this.appartamento = appartamento;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public void setPagato(boolean pagato) {
        this.pagato = pagato;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
