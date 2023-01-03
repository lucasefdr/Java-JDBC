package io.github.lucasefdr.aulas.test;

import io.github.lucasefdr.aulas.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class TestePoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try (Connection connection = connectionFactory.connection()) {

            for (int conexao = 0; conexao <= 20; conexao++) {
                connectionFactory.connection();
                System.out.println("Conexão de número: " + conexao);
            }
        }
    }
}