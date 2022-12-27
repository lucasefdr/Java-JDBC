package io.github.lucasefdr.test;

import io.github.lucasefdr.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {
    public static void main(String... args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        Statement statement = connection.createStatement();
        // statement.executeUpdate("""
        // INSERT INTO employees (employee_id, first_name, last_name, email, hire_date,
        // job_id)
        // VALUES (employees_seq.nextval, 'Lucas', 'Vinicius', 'LVINI', SYSDATE,
        // 'IT_PROG')
        // """);
        statement.execute("SELECT * FROM employees WHERE first_name = 'Lucas'");

        ResultSet rs = statement.getResultSet();

        while (rs.next()) {
            Integer id = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            System.out.println("Employee ID: " + id);
            System.out.println("Full name: " + firstName + " " + lastName);
            System.out.println();
        }

        connection.close();
    }
}
