/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.bd;

import java.util.ArrayList;
import java.util.List;
import br.edu.unicesumar.persistencia.model.Produto;

/**
 *
 * @author Lauder
 */
public class ProdutoCrud implements CrudInterface<Produto> {

    @Override
    public void inserir(Produto objeto) {
        System.out.println("Função não implementada");
    }

    @Override
    public void alterar(Produto objeto) {
        System.out.println("Função não implementada");
    }

    @Override
    public Produto recuperar(int id) {
        System.out.println("Função não implementada");
        return new Produto();
    }

    @Override
    public void excluir(Produto objeto) {
        System.out.println("Função não implementada");
    }

    @Override
    public List<Produto> listar() {
        System.out.println("Função não implementada");
        return new ArrayList<>();
    }
    
}