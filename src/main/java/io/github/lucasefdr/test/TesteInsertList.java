package io.github.lucasefdr.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import io.github.lucasefdr.factory.ConnectionFactory;
import io.github.lucasefdr.dao.ProdutoDAO;
import io.github.lucasefdr.model.Produto;

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
