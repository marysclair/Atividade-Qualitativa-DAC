package com.projeto.adocaoDeAnimais.dao;

import com.projeto.adocaoDeAnimais.conexao.ConnectionFactory;
import com.projeto.adocaoDeAnimais.entities.Adocao;
import com.projeto.adocaoDeAnimais.entities.Animal;
import com.projeto.adocaoDeAnimais.entities.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdocaoDao {

    private Connection connection;

    public AdocaoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insereAdocao(Adocao adocao) throws SQLException {
        String sql = "insert into adocao (idtutor, idanimal, data, motivo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, adocao.getTutor().getId());
            stmt.setLong(2, adocao.getAnimal().getId());
            stmt.setDate(3, java.sql.Date.valueOf(adocao.getData()));
            stmt.setString(4, adocao.getMotivo());
            stmt.execute();
        }
    }

    public Adocao buscaAdocaoPorId(Long id) throws SQLException{
        String sql = "select * from adocao where id=?";
        Adocao adocao = new Adocao();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                adocao.setId(rs.getLong("id"));
                TutorDao tutorDao = new TutorDao();
                Tutor tutor = tutorDao.buscaTutorPorId(rs.getLong("idtutor"));
                adocao.setTutor(tutor);
                AnimalDao animalDao = new AnimalDao();
                Animal animal = animalDao.buscaAnimalPorId(rs.getLong("idanimal"));
                adocao.setAnimal(animal);
                adocao.setData(rs.getDate("data").toLocalDate());
                adocao.setMotivo(rs.getString("motivo"));
            }
            return adocao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Adocao> buscaTodasAdocoes() throws SQLException{
        ArrayList<Adocao> adocoes = new ArrayList<>();
        String sql = "select * from adocao";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Adocao adocao = new Adocao();
                    adocao.setId(rs.getLong("id"));
                    TutorDao tutorDao = new TutorDao();
                    Tutor tutor = tutorDao.buscaTutorPorId(rs.getLong("idtutor"));
                    adocao.setTutor(tutor);
                    AnimalDao animalDao = new AnimalDao();
                    Animal animal = animalDao.buscaAnimalPorId(rs.getLong("idanimal"));
                    adocao.setAnimal(animal);
                    adocao.setData(rs.getDate("data").toLocalDate());
                    adocao.setMotivo(rs.getString("motivo"));

                    adocoes.add(adocao);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return adocoes;
    }

    public Adocao atualizaAdocao(Adocao adocao) throws SQLException {
        String sql = "update adocao set idtutor=?, idanimal=?, data=?, motivo=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, adocao.getTutor().getId());
            stmt.setLong(2, adocao.getAnimal().getId());
            stmt.setDate(3, java.sql.Date.valueOf(adocao.getData()));
            stmt.setString(4, adocao.getMotivo());
            stmt.setLong(5, adocao.getId());
            stmt.executeUpdate();
            return adocao;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    public void deletaAdocao(Long id) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from adocao where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
