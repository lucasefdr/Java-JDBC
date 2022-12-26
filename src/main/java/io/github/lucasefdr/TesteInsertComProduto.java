package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.lucasefdr.model.Produto;

public class TesteInsertComProduto {
    public static void main(String[] args) throws SQLException {

        Produto cama = new Produto("Bermuda", "Bermuda jeans");

        try (Connection connection = new ConnectionFactory().connection()) {
            String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, cama.getNome());
                preparedStatement.setString(2, cama.getDescricao());

                preparedStatement.execute();

                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        cama.setId(resultSet.getInt(1));
                    }
                }
            }
        }
        System.out.println(cama.getId());
    }
}