package com.projeto.adocaoDeAnimais.entities;

import java.time.LocalDate;

public class Adocao {
    private Long id;
    Tutor tutor = new Tutor();
    Animal animal = new Animal();
    private LocalDate data;
    private String motivo;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + 
                "\nData: " + getData() +
                "\nMotivo: " + getMotivo() +
                "\nTutor:\n" + getTutor() +
                "\nAnimal:\n" + getAnimal();
    }
}
