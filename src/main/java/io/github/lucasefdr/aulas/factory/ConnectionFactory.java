package io.github.lucasefdr.aulas.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Design pattern: Factory -> fábrica de construção de objetos
public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Java-JDBC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("258456");

        // Configurando o máximo de conexões no pool
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection connection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
