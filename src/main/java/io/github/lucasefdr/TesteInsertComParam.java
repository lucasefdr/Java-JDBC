package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsertComParam {
    public static void main(String... args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        String nome = "Mouse";
        String descricao = "Mouse sem fio Logitech";
        Double valor = 140.0D;

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO produto (nome, descricao, valor) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setDouble(3, valor);

        preparedStatement.execute();

        ResultSet rs = preparedStatement.executeQuery("SELECT * FROM produto ORDER BY id");

        while (rs.next()) {
            String nomeProduto = rs.getString("nome");
            Integer idProduto = rs.getInt("id");

            System.out.println("ID: " + idProduto + ", Nome: " + nomeProduto);
        }

        connection.close();
    }
}
