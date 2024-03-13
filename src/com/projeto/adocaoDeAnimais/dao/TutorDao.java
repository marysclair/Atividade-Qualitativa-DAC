package com.projeto.adocaoDeAnimais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.adocaoDeAnimais.conexao.ConnectionFactory;
import com.projeto.adocaoDeAnimais.entities.Tutor;

public class TutorDao {
    private Connection connection;

	public TutorDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

    public Tutor insereTutor(Tutor tutor){
        String sql = "insert into tutor (nome, telefone, endereco, cpf) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tutor.getNome());
			stmt.setString(2, tutor.getTelefone());
			stmt.setString(3, tutor.getEndereco());
			stmt.setString(4, tutor.getCpf());
			stmt.execute();
			stmt.close();
            return tutor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public Tutor buscaTutorPorId(Long id){
        String sql = "select * from tutor where id=?";
        Tutor tutor = new Tutor();
        try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tutor.setId(rs.getLong("id"));
                tutor.setNome(rs.getString("nome"));
                tutor.setEndereco(rs.getString("endereco"));
                tutor.setTelefone(rs.getString("telefone"));
                tutor.setCpf(rs.getString("cpf"));
			}
			return tutor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public ArrayList<Tutor> buscaTodosTutores(){
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();
        String sql = "select * from tutor";
        try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                Tutor tutor = new Tutor();
				tutor.setId(rs.getLong("id"));
                tutor.setNome(rs.getString("nome"));
                tutor.setEndereco(rs.getString("endereco"));
                tutor.setTelefone(rs.getString("telefone"));
                tutor.setCpf(rs.getString("cpf"));
                tutores.add(tutor);
			}
            rs.close();
			stmt.close();
            return tutores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    public void deletaTutor(Long id){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from tutor where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tutor atualizaTutor(Tutor tutor){
        String sql = "update tutor set telefone=?, endereco=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tutor.getTelefone());
            stmt.setString(2, tutor.getEndereco());
            stmt.setLong(3, tutor.getId());
            stmt.execute();
            stmt.close();
            return tutor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
