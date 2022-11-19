/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia;

import br.edu.unicesumar.persistencia.telas.Menu;
import java.util.Scanner;

/**
 *
 * @author Lauder
 */
public class Principal {
    public static void main(String[] args) {
        int opcaoMenu = 0;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        do{
            menu.imprimirMenu();
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();
            menu.processarOpcaoMenu(opcaoMenu);
        }while(opcaoMenu != 9);
    }
}
