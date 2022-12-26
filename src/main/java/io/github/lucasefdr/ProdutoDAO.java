package io.github.lucasefdr;

import io.github.lucasefdr.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    produto.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }
}