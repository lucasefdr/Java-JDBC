package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Design pattern: Factory -> fábrica de construção de objetos
public class ConnectionFactory {
    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "kneladev",
                "kneladev");
    }
}
