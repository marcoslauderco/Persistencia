/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.telas;

import br.edu.unicesumar.persistencia.bd.CategoriaCrud;
import br.edu.unicesumar.persistencia.bd.ProdutoCrud;
import java.util.List;
import java.util.Scanner;
import model.Categoria;
import model.Produto;

/**
 *
 * @author Lauder
 */
public class ProdutoTela extends Tela{
    
    private ProdutoCrud produtoCrud;
    private CategoriaCrud categoriaCrud;

    public ProdutoTela(Scanner scanner) {
        super(scanner);
        this.produtoCrud = new ProdutoCrud();
        this.categoriaCrud = new CategoriaCrud();
    }
    
    private void preencherCampos(Produto produto){
        System.out.println("Informe o Nome do Produto");
        produto.setNome(scanner.nextLine());
        System.out.println("Informe a Descrição do Produto");
        produto.setDescricao(scanner.nextLine());
        System.out.println("Informe o Preço do Produto");
        produto.setPreco(scanner.nextDouble());
        System.out.println("Informe o id Da Categoria do Produto");
        this.mostrarCategorias();
        int idCategoria = scanner.nextInt();
        scanner.nextLine();
        Categoria categoria = this.categoriaCrud.recuperar(idCategoria);
        produto.setCategoria(categoria);
    }
    
    private void mostrarCategorias(){
        List<Categoria> categorias = (List<Categoria>) this.categoriaCrud.listar();
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
    
    private Produto recuperar(){
        System.out.println("Informe o id do Produto:");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        Produto recuperado = this.produtoCrud.recuperar(id);
        System.out.println(recuperado);
        return recuperado;
    }
    
    public void cadastrar(){
        Produto produto = new Produto();
        this.preencherCampos(produto);
        produtoCrud.inserir(produto);
        this.mensagem("Produto Cadastrado!");
    }
    
    public void alterar(){
        Produto produto = this.recuperar();
        this.preencherCampos(produto);
        produtoCrud.alterar(produto);
        this.mensagem("Produto Alterado!");
    }
    
    public void excluir(){
        Produto produto = this.recuperar();
        System.out.println("Deseja realmente excluir o Produto? (sim/não)");
        String op = scanner.nextLine();
        if(op.toLowerCase().equals("sim")){
            this.produtoCrud.excluir(produto);
            this.mensagem("Produto Excluido!");
        }else{
            this.mensagem("Operação cancelada.");
        }
    }
    
    public void listar(){
        System.out.println("ID - Descição - Valor");
        List<Produto> produtos = this.produtoCrud.listar();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        this.mensagem("Fim da lista...");
    }
}
