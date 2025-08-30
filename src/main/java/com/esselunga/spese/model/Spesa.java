package com.esselunga.spese.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Spesa {
    @Id
    @GeneratedValue

    private Long id;
    private double LatConsegna;
    private double lonConsegna;

    @ElementCollection //Per salvare una lista di stringhe
    private List<String> articoli;
    private String stato; //E. g. "In Elaborazione"
    private LocalDateTime dataCreazione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatConsegna() {
        return LatConsegna;
    }

    public void setLatConsegna(double latConsegna) {
        LatConsegna = latConsegna;
    }

    public double getLonConsegna() {
        return lonConsegna;
    }

    public void setLonConsegna(double lonConsegna) {
        this.lonConsegna = lonConsegna;
    }

    public List<String> getArticoli() {
        return articoli;
    }

    public void setArticoli(List<String> articoli) {
        this.articoli = articoli;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spesa spesa = (Spesa) o;
        return Double.compare(LatConsegna, spesa.LatConsegna) == 0 && Double.compare(lonConsegna, spesa.lonConsegna) == 0 && Objects.equals(id, spesa.id) && Objects.equals(articoli, spesa.articoli) && Objects.equals(stato, spesa.stato) && Objects.equals(dataCreazione, spesa.dataCreazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, LatConsegna, lonConsegna, articoli, stato, dataCreazione);
    }

}
