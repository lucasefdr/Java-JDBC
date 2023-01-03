package io.github.lucasefdr.projeto.controller;

import io.github.lucasefdr.projeto.dao.CategoriaDAO;
import io.github.lucasefdr.projeto.factory.ConnectionFactory;
import io.github.lucasefdr.projeto.model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.categoriaDAO = new CategoriaDAO(connection);
    }

    public List<Categoria> listar() {
        return this.categoriaDAO.listarTodos();
    }
}
