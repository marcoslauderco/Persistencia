/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.bd;

import br.edu.unicesumar.persistencia.model.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lauder
 */
public class CategoriaCrud implements CrudInterface<Categoria> {

    private Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "localhost";
    private final String DATA_BASE = "persistencia";
    private final String DB_USUARIO = "unicesumar";
    private final String DB_SENHA = "unicesumar";
    
    public CategoriaCrud() {
        String url = "jdbc:mysql://"+this.SERVER+"/"+this.DATA_BASE;
        try {
            this.conexao = DriverManager.getConnection(url,this.DB_USUARIO,this.DB_SENHA);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    @Override
    public void inserir(Categoria objeto) {
        try {
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO categorias(descricao) VALUES (?)");
            sql.setString(1, objeto.getDescricao());
            sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Categoria objeto) {
        try {
            PreparedStatement sql = conexao.prepareStatement("UPDATE categorias SET descricao = ? WHERE id = ?");
            sql.setInt(2, objeto.getId());
            sql.setString(1, objeto.getDescricao());
            sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categoria recuperar(int id) {
        Categoria categoria = new Categoria();
        try {
            PreparedStatement sql = conexao.prepareStatement("Select * from categorias WHERE id = ?");
            sql.setInt(1, id);
            ResultSet result = sql.executeQuery();
            result.next();
            categoria.setId(result.getInt("id"));
            categoria.setDescricao(result.getString("descricao"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public void excluir(Categoria objeto) {
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM categorias WHERE id = ?");
            sql.setInt(1, objeto.getId());
            sql.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> retorno = new ArrayList<Categoria>();
        try {
            PreparedStatement sql = conexao.prepareStatement("Select * from categorias");
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("id"));
                categoria.setDescricao(result.getString("descricao"));
                retorno.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
}
