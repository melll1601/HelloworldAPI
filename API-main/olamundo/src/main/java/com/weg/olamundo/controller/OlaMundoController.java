package com.weg.olamundo.controller;

import com.weg.olamundo.model.Usuario;
import com.weg.olamundo.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class OlaMundoController {

    UserRepo repo = new UserRepo();

    @GetMapping("/id")
    public List<Usuario> buscarIDTeste () throws SQLException {
        List<Usuario> lista = repo.listarUser();
        return lista;
    }

    @PostMapping("/post")
    public String postUsuario(@RequestBody Usuario usuario) throws SQLException {
        repo.adicionarUser(usuario);
        return "Usuário salvo com sucesso";
    }

}
