package com.cep.cep.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Cep implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ds_cep")
    private String dsCep;

    @Column(name = "ds_logradouro")
    private String dsLogradouro;

    @Column(name = "ds_bairro")
    private String dsBairro;

    @Column(name = "ds_estado")
    private String dsEstado;

    @Column(name = "nr_ddd")
    private int nrDdd;

    public Cep() {}

    public Cep(String dsCep, String dsLogradouro, String dsBairro, String dsEstado, int nrDdd) {
        this.dsCep = dsCep;
        this.dsLogradouro = dsLogradouro;
        this.dsBairro = dsBairro;
        this.dsEstado = dsEstado;
        this.nrDdd = nrDdd;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDsCep() {
        return dsCep;
    }

    public void setDsCep(String dsCep) {
        this.dsCep = dsCep;
    }

    public String getDsLogradouro() {
        return dsLogradouro;
    }

    public void setDsLogradouro(String dsLogradouro) {
        this.dsLogradouro = dsLogradouro;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public String getDsEstado() {
        return dsEstado;
    }

    public void setDsEstado(String dsEstado) {
        this.dsEstado = dsEstado;
    }

    public int getNrDdd() {
        return nrDdd;
    }

    public void setNrDdd(int nrDdd) {
        this.nrDdd = nrDdd;
    }

    @Override
    public String toString() {
        return "Cep{" +
                "id=" + id +
                ", dsCep='" + dsCep + '\'' +
                ", dsLogradouro='" + dsLogradouro + '\'' +
                ", dsBairro='" + dsBairro + '\'' +
                ", dsEstado='" + dsEstado + '\'' +
                ", nrDdd=" + nrDdd +
                '}';
    }
}
