/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.telas;

import br.edu.unicesumar.persistencia.bd.CategoriaCrud;
import java.util.List;
import java.util.Scanner;
import br.edu.unicesumar.persistencia.model.Categoria;

/**
 *
 * @author Lauder
 */
public class CategoriaTela extends Tela{
    
    private CategoriaCrud categoriaCrud;

    public CategoriaTela(Scanner scanner) {
        super(scanner);
        this.categoriaCrud = new CategoriaCrud();
    }
    
    private void preencherCampos(Categoria categoria){
        System.out.println("Informe a descrição da Categoria");
        categoria.setDescricao(scanner.nextLine());
    }
    
    private Categoria recuperar(){
        System.out.println("Informe o id da categoria:");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        Categoria recuperada = this.categoriaCrud.recuperar(id);
        System.out.println(recuperada);
        return recuperada;
    }
    
    public void cadastrar(){
        Categoria categoria = new Categoria();
        this.preencherCampos(categoria);
        categoriaCrud.inserir(categoria);
        this.mensagem("Categoria Cadastrada!");
    }
    
    public void alterar(){
        Categoria categoria = this.recuperar();
        this.preencherCampos(categoria);
        categoriaCrud.alterar(categoria);
        this.mensagem("Categoria Alterada!");
    }
    
    public void excluir(){
        Categoria categoria = this.recuperar();
        System.out.println("Deseja realmente excluir a categoria? (sim/não)");
        String op = scanner.nextLine();
        if(op.toLowerCase().equals("sim")){
            this.categoriaCrud.excluir(categoria);
            this.mensagem("Categoria Excluida!");
        }else{
            this.mensagem("Operação cancelada.");
        }
    }
    
    public void listar(){
        System.out.println("ID - Descição");
        List<Categoria> categorias = (List<Categoria>) this.categoriaCrud.listar();
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
        this.mensagem("Fim da lista...");
    }
   
}
