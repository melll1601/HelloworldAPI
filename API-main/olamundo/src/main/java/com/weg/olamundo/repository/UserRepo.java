package com.weg.olamundo.repository;

import com.weg.olamundo.Conexao.Conexao;
import com.weg.olamundo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    public List<Usuario> listarUser () throws SQLException {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT id, nome, email FROM `User`";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email")
                    );
                    lista.add(usuario);
                }
        }
        return lista;
    }

    public void adicionarUser(Usuario usuario) throws SQLException{

        String query = """
                INSERT into
                `User` (nome, email)
                VALUES (?, ?)
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

            System.out.println("Usuário Adicionado");

        }catch (SQLException error){
            error.printStackTrace();
        }
    }

}
