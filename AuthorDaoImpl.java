/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.entities.Author;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author andpa
 */

public class AuthorDaoImpl implements AuthorDao {

    private SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Author> findAll() {
       Query q = getSession().createQuery("SELECT a FROM Author a");
         List<Author> list = q.getResultList();
         return list;
    }

    @Override
    public void createOrUpdate(Author a) {
        getSession().saveOrUpdate(a);
    }

    @Override
    public void delete(int id) {
        Query q = getSession().createNamedQuery("author.deleteById");
        q.setParameter("kwdikos", id);
        int result = q.executeUpdate();
    }

    @Override
    public Author findById(Integer id) {
         return (Author)getSession().get(Author.class, id);
    }

    @Override
    public List<Author> findAuthorByName(String searchName) {
         Query q = getSession().createNamedQuery("author.findLikeName");
        q.setParameter("name", "%"+searchName+"%");
        List<Author> list = q.getResultList();
        return list;
    }

    
}

