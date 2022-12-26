package io.github.lucasefdr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import io.github.lucasefdr.model.Produto;

public class TesteInsertList {
    public static void main(String[] args) throws SQLException {

        Produto cama = new Produto("Cama", "Cama king size");

        try (Connection connection = new ConnectionFactory().connection()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(cama);

            List<Produto> produtos = produtoDAO.listarTodos();

            produtos.forEach(System.out::println);
        }
    }

}
