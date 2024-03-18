package com.projeto.adocaoDeAnimais.dao;

import com.projeto.adocaoDeAnimais.conexao.ConnectionFactory;
import com.projeto.adocaoDeAnimais.entities.Animal;
import com.projeto.adocaoDeAnimais.entities.Tutor;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDao {

    private Connection connection;

    public AnimalDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Animal insereAnimal(Animal animal){
        String sql = "insert into animal (dataNascimento, nome, personalidade, especie, raca) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(animal.getDataNascimento()));
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getPersonaldiade());
            stmt.setString(4, animal.getEspecie());
            stmt.setString(5, animal.getRaca());
            stmt.execute();
            stmt.close();
            return animal;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Animal buscaAnimalPorId(Long id){
        String sql = "select * from animal where id=?";
        Animal animal = new Animal();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                animal.setId(rs.getLong("id"));
                animal.setDataNascimento(rs.getTimestamp("dataNascimento").toLocalDateTime().toLocalDate());
                animal.setNome(rs.getString("nome"));
                animal.setPersonalidade(rs.getString("personalidade"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
            }
            return animal;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Animal> buscaTodosAnimais(){
        ArrayList<Animal> animais = new ArrayList<Animal>();
        String sql = "select * from animal";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getLong("id"));
                animal.setNome(rs.getString("nome"));
                animal.setDataNascimento(rs.getTimestamp("dataNascimento").toLocalDateTime().toLocalDate());
                animal.setPersonalidade(rs.getString("personalidade"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animais.add(animal);
            }
            rs.close();
            stmt.close();
            return animais;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Animal atualizaAnimal(Animal animal){
        String sql = "update animal set nome=?, dataNascimento=?, personalidade=?, especie=?, raca=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setDate(2, Date.valueOf(animal.getDataNascimento().toString()));
            stmt.setString(3, animal.getPersonaldiade());
            stmt.setString(4, animal.getEspecie());
            stmt.setString(5, animal.getRaca());
            stmt.setLong(6, animal.getId());
            stmt.execute();
            stmt.close();
            return animal;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletaAnimal(Long id){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from animal where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


