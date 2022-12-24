package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        // Usando a factory de conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        // Guardando o resultado de uma query em um ResultSet
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM EMPLOYEES");

        while (rs.next()) {
            Integer id = rs.getInt("employee_id");
            String first_name = rs.getString("first_name");

            System.out.println("ID: " + id + " - First name: " + first_name);
        }

        connection.close();
    }
}
