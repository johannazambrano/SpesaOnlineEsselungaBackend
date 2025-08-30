package com.esselunga.spese.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class Magazzino {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private double lat;
    private double lon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazzino magazzino = (Magazzino) o;
        return Double.compare(lat, magazzino.lat) == 0 && Double.compare(lon, magazzino.lon) == 0 && Objects.equals(id, magazzino.id) && Objects.equals(nome, magazzino.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, lat, lon);
    }

    @Override
    public String toString() {
        return "Magazzino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

