package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Design pattern: Factory -> fábrica de construção de objetos
public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
        comboPooledDataSource.setUser("kneladev");
        comboPooledDataSource.setPassword("kneladev");

        this.dataSource = comboPooledDataSource;
    }

    public Connection connection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
