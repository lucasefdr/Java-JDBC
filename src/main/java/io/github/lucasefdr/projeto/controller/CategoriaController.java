package io.github.lucasefdr.projeto.controller;

import io.github.lucasefdr.projeto.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    public List<Categoria> listar() {
        List<Categoria> categorias =
                new ArrayList<Categoria>();
        categorias.add(new Categoria(1, "Categoria de teste"));
        return categorias;
    }
}
