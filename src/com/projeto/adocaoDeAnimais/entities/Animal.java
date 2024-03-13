package com.projeto.adocaoDeAnimais.entities;

public class Animal {
    private Long id;
    private int idade;
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
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
    public void setPersonaldiade(String personaldiade) {
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
}
