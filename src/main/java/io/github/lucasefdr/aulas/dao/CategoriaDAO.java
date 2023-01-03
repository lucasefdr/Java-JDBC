package io.github.lucasefdr.aulas.dao;

import io.github.lucasefdr.aulas.model.Produto;
import io.github.lucasefdr.aulas.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private final Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listarTodos() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
                    categorias.add(categoria);
                }
            }
        }
        return categorias;
    }

    public List<Categoria> listarComProdutos() throws SQLException {
        Categoria ultimaCategoria = null;
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM categoria c INNER JOIN produto p ON c.id = p.categoria_id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    if (ultimaCategoria == null || !ultimaCategoria.getNome().equals(resultSet.getString(2))) {
                        Categoria categoria = new Categoria(resultSet.getInt(1),
                                resultSet.getString(2));

                        ultimaCategoria = categoria;
                        categorias.add(categoria);
                    }

                    Produto produto = new Produto(resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5));

                    ultimaCategoria.adicionarProduto(produto);
                }
            }
            return categorias;
        }
    }
}
