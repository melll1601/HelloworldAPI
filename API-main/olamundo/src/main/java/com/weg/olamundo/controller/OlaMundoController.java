package com.weg.olamundo.controller;

import com.weg.olamundo.model.Usuario;
import com.weg.olamundo.repository.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class OlaMundoController {
    @GetMapping("/id")
    public List<Usuario> buscarIDTeste () throws SQLException {
        UserRepo repo = new UserRepo();
        List<Usuario> lista = repo.listarUser();
        return lista;
    }
}
