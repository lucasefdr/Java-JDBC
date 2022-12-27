package io.github.lucasefdr.test;

import io.github.lucasefdr.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsertComParam {
    public static void main(String... args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // try with resources
        try (Connection connection = connectionFactory.connection()) {

            // Controlando as transações não automáticas
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO produto (nome, descricao, valor) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS)) {

                adicionarVariavel("SmartTV", "40 polegadas", 2340.0D, preparedStatement);
                adicionarVariavel("Notebook", "Lenovo S45", 3540.0D, preparedStatement);

                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                connection.rollback();
            }

            try (ResultSet rs = connection.prepareStatement("SELECT * FROM produto ORDER BY id").executeQuery()) {

                while (rs.next()) {
                    String nomeProduto = rs.getString("nome");
                    int idProduto = rs.getInt("id");

                    System.out.println("ID: " + idProduto + " - Nome: " + nomeProduto);
                }
            }
        }
    }

    public static void adicionarVariavel(String nome, String descricao, Double valor, PreparedStatement pstm)
            throws Exception {
        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.setDouble(3, valor);

        if (nome.equals("Notebook"))
            throw new Exception("Error");

        pstm.execute();
    }
}
