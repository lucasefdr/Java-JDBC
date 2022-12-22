package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        // Fazendo conexão com o banco de dados Oracle
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "kneladev",
                "kneladev");

        try {
            // Guardando o resultado de uma querie nem um ResultSet
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM EMPLOYEES");
            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }
        } catch (Exception e) {

        } finally {
            connection.close();
        }

    }
}
