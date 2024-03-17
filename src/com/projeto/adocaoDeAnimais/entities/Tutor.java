package com.projeto.adocaoDeAnimais.entities;

public class Tutor {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + 
                "\nNome: " + getNome() +
                "\nTelefone: " + getTelefone() +
                "\nEndereço: " + getEndereco() +
                "\nCPF: " + getCpf();
    } 
}