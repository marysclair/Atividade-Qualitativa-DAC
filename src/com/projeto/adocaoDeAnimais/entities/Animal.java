package com.projeto.adocaoDeAnimais.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Animal {
    private Long id;
    private LocalDate dataNascimento;
    private String nome;
    private String personaldiade;
    private String especie;
    private String raca;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPersonaldiade() {
        return personaldiade;
    }
    public void setPersonalidade(String personaldiade) {
        this.personaldiade = personaldiade;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + 
                "\nNome: " + getNome() +
                "\nData de nascimento: " + getDataNascimento() +
                "\nPersonalidade: " + getPersonaldiade() +
                "\nEspecie: " + getEspecie() +
                "\nRaca: " + getRaca();
    }
}
