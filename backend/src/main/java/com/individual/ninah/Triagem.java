package com.individual.ninah;

import java.util.Date;
import java.util.List;

public class Triagem {
    private Integer id;
    private String nome;
    private Integer idade;
    private Date dataNascimento;
    private String senteDor;
    private String sintomas;
    private String pais;

    public Triagem() {
    }

    public Triagem(Integer id, String nome, Integer idade, Date dataNascimento, String senteDor, String sintomas, String pais) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.senteDor = senteDor;
        this.sintomas = sintomas;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenteDor() {
        return senteDor;
    }

    public void setSenteDor(String senteDor) {
        this.senteDor = senteDor;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
