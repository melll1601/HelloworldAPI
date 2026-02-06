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
}
