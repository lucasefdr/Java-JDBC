package io.github.lucasefdr.test;

import io.github.lucasefdr.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteSelect {
    public static void main(String[] args) throws SQLException {

        // Usando a factory de conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        // Guardando o resultado de uma query em um ResultSet
        ResultSet rs = connection.prepareStatement("SELECT * FROM produto").executeQuery();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");

            System.out.println("ID: " + id + " - Produto: " + nome);
        }

        connection.close();
    }
}
