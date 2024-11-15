package com.cep.cep.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ds_nome")
    private String dsNome;

    @Column(name = "ds_cpf")
    private String dsCpf;

    @Column(name = "ds_senha")
    private String dsSenha;

    public Login() {}

    public Login(String dsNome, String dsCpf, String dsSenha) {
        this.dsNome = dsNome;
        this.dsCpf = dsCpf;
        this.dsSenha = dsSenha;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getDsCpf() {
        return dsCpf;
    }

    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", dsNome='" + dsNome + '\'' +
                ", dsCpf='" + dsCpf + '\'' +
                ", dsSenha='" + dsSenha + '\'' +
                '}';
    }
}
