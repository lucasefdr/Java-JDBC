package io.github.lucasefdr;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteDelete {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();

        // Criando a declaração
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM employees WHERE first_name = 'Lara' AND last_name = 'Maria'",
                Statement.RETURN_GENERATED_KEYS);

        // Quantas linhas foram modificadas depois do execute
        Integer linhasModificadas = statement.getUpdateCount();

        System.out.println("Quantidade de linhas que foram removidas: " + linhasModificadas);
    }
}
