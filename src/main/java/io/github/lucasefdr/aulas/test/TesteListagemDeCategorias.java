package io.github.lucasefdr.aulas.test;

import io.github.lucasefdr.aulas.dao.CategoriaDAO;
import io.github.lucasefdr.aulas.factory.ConnectionFactory;
import io.github.lucasefdr.aulas.model.Categoria;
import io.github.lucasefdr.aulas.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().connection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();

            listaDeCategorias.forEach(categoria -> {
                System.out.println(categoria.getNome());


                for (Produto produto : categoria.getProdutos()) {
                    System.out.println(" - " + produto.getNome() + ": " + produto.getDescricao());
                }
            });
        }
    }
}