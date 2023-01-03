package io.github.lucasefdr.aulas.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import io.github.lucasefdr.aulas.model.Produto;
import io.github.lucasefdr.aulas.factory.ConnectionFactory;
import io.github.lucasefdr.aulas.dao.ProdutoDAO;

public class TesteInsertList {
    public static void main(String[] args) throws SQLException {

        Produto geladeira = new Produto("Geladeira", "Geladeira Electrolux");

        try (Connection connection = new ConnectionFactory().connection()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(geladeira);

            List<Produto> produtos = produtoDAO.listarTodos();

            produtos.forEach(System.out::println);
        }
    }

}
