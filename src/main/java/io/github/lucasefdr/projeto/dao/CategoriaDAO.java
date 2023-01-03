package io.github.lucasefdr.projeto.dao;

import io.github.lucasefdr.projeto.model.Categoria;
import io.github.lucasefdr.projeto.model.Produto;

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

    public List<Categoria> listarTodos() {
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
