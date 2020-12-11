package com.polimi.nightdream.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.polimi.nightdream.utils.MyUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appartamento implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @NotNull
    private Proprietario proprietario;

    @OneToMany(mappedBy = "appartamento")
    @JsonManagedReference
    @JsonIgnore
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

    public Appartamento() {}

    public Appartamento(@NotNull Proprietario proprietario, List<Prenotazione> listaPrenotazioni, String nome, String indirizzo, int numCamere, int numBagni, int postiLetto, double prezzo, boolean bagnoCamera, boolean televisione, boolean cucina) {
        this.proprietario = proprietario;
        this.listaPrenotazioni = listaPrenotazioni;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numCamere = numCamere;
        this.numBagni = numBagni;
        this.postiLetto = postiLetto;
        this.prezzo = prezzo;
        this.bagnoCamera = bagnoCamera;
        this.televisione = televisione;
        this.cucina = cucina;
    }

    //Getter

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public Integer getId() {
        return id;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getNumCamere() {
        return numCamere;
    }

    public int getNumBagni() {
        return numBagni;
    }

    public int getPostiLetto() {
        return postiLetto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isBagnoCamera() {
        return bagnoCamera;
    }

    public boolean isTelevisione() {
        return televisione;
    }

    public boolean isCucina() {
        return cucina;
    }


    //Setter

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public void setNumCamere(int camera) {
        this.numCamere = camera;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setNumBagni(int numBagni) {
        this.numBagni = numBagni;
    }

    public void setPostiLetto(int postiLetto) {
        this.postiLetto = postiLetto;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setTelevisione(boolean televisione) {
        this.televisione = televisione;
    }

    public void setBagnoCamera(boolean bagnoInCamera) {
        this.bagnoCamera = bagnoInCamera;
    }

    public void setCucina(boolean cucina) {
        this.cucina = cucina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Appartamento appartamento = (Appartamento) o;

        return new EqualsBuilder()
                .append(nome, appartamento.nome)
                .append(indirizzo, appartamento.indirizzo)
                .append(numCamere, appartamento.numCamere)
                .append(numBagni, appartamento.numBagni)
                .append(postiLetto, appartamento.postiLetto)
                .append(prezzo, appartamento.prezzo)
                .append(televisione, appartamento.televisione)
                .append(bagnoCamera, appartamento.bagnoCamera)
                .append(cucina, appartamento.cucina)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(indirizzo)
                .append(numCamere)
                .append(numBagni)
                .append(postiLetto)
                .append(prezzo)
                .append(televisione)
                .append(bagnoCamera)
                .append(cucina)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Appartamento {" +
                "id = " + id + ", " +
                "nome = '" + nome + "\', " +
                "indirizzo = " + indirizzo + ", " +
                "num_camere = " + numCamere + ", " +
                "num_bagni = " + numBagni + ", " +
                "posti_letto = " + postiLetto + ", " +
                "prezzo = " + prezzo + " €, " +
                "televisione = " + MyUtils.booleanToString(televisione) + ", " +
                "bagno_in_camera = " + MyUtils.booleanToString(bagnoCamera) + ", " +
                "cucina = " + MyUtils.booleanToString(cucina) + "}";
    }
}
