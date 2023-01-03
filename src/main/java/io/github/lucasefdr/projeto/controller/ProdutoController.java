package io.github.lucasefdr.projeto.controller;

import io.github.lucasefdr.projeto.dao.ProdutoDAO;
import io.github.lucasefdr.projeto.factory.ConnectionFactory;
import io.github.lucasefdr.projeto.model.Produto;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void deletar(Integer id) {
        this.produtoDAO.deletar(id);
    }

    public void salvar(Produto produto) {
        this.produtoDAO.salvar(produto);
    }

    public List<Produto> listar() {
        return this.produtoDAO.listar();
    }

    public void alterar(String nome, String descricao, Integer id) {
        this.produtoDAO.alterar(nome, descricao, id);
    }
}
