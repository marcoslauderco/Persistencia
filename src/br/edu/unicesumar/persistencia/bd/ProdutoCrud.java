/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unicesumar.persistencia.bd;

import br.edu.unicesumar.persistencia.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import br.edu.unicesumar.persistencia.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Lauder
 */
public class ProdutoCrud implements CrudInterface<Produto> {
    EntityManager em;

    public ProdutoCrud() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlpu");
        em = emf.createEntityManager();
    }
    
    @Override
    public void inserir(Produto objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Produto objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    @Override
    public Produto recuperar(int id) {
        return em.find(Produto.class, id);
    }

    @Override
    public void excluir(Produto objeto) {
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    @Override
    public List<Produto> listar() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> root = cq.from(Produto.class);
        Join<Produto,Categoria> categoriaJoin = root.join("categoria");
        //cq.where(cb.greaterThan(root.get("preco"), 100));
        //cq.where(cb.equal(categoriaJoin.get("id"), 1));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
}