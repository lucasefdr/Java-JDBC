package io.github.lucasefdr.aulas.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return String.format("Informações da categoria %d: %s", this.id, this.nome);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
