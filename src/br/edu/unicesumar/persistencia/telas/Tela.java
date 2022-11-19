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
public abstract class Tela {
    protected Scanner scanner;

    public Tela(Scanner scanner) {
        this.scanner = scanner;
    }
    
    protected void mensagem(String mensagem){
        System.out.println(mensagem + " aperte Enter para continuar.");
        scanner.nextLine();
        this.limparTela();
    }
    
    public static void limparTela(){
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }
}