/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.bd;

import java.util.List;

/**
 *
 * @author Lauder
 */
public interface CrudInterface<E> {
    public void inserir(E objeto);
    public void alterar(E objeto);
    public E recuperar(int id);
    public void excluir(E objeto);
    public List<E> listar();
}
