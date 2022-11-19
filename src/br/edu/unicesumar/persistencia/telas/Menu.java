/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.telas;

import java.util.Scanner;

/**
 *
 * @author Lauder
 */
public class Menu extends Tela{
    
    private CategoriaTela categoriaTela;
    private ProdutoTela produtoTela;

    public Menu(Scanner scanner) {
        super(scanner);
        this.categoriaTela = new CategoriaTela(scanner);
        this.produtoTela = new ProdutoTela(scanner);
    }
    
    public void imprimirMenu(){
        System.out.println("------ Controle de Produtos ------");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Alterar Produto");
        System.out.println("3 - Excluir Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("5 - Cadastrar Categoria");
        System.out.println("6 - Alterar Categoria");
        System.out.println("7 - Excluir Categoria");
        System.out.println("8 - Listar Categorias");
        System.out.println("9 - Sair");
        System.out.println("-----------------------------------");
    }
    
    public void processarOpcaoMenu(int opcaoMenu){
        limparTela();
        switch(opcaoMenu){
            case 1:
                this.produtoTela.cadastrar();
                break;
            case 2:
                this.produtoTela.alterar();
                break;
            case 3:
                this.produtoTela.excluir();
                break;
            case 4:
                this.produtoTela.listar();
                break;
            case 5:
                this.categoriaTela.cadastrar();
                break;
            case 6:
                this.categoriaTela.alterar();
                break;
            case 7:
                this.categoriaTela.excluir();
                break;
            case 8:
                this.categoriaTela.listar();
                break;
        }
    }
}