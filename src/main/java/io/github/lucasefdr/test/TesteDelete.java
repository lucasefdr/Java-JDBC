package io.github.lucasefdr.test;

import io.github.lucasefdr.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDelete {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        // Criando a declaração
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto");
        // preparedStatement.setString(1, "Mouse");
        preparedStatement.execute();

        // Quantas linhas foram modificadas depois do execute
        Integer linhasModificadas = preparedStatement.getUpdateCount();
        System.out.println("Quantidade de linhas que foram removidas: " + linhasModificadas);
    }
}
