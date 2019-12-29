/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dao;

import com.mycompany.entities.Author;
import java.util.List;

/**
 *
 * @author andpa
 */
    
    public interface AuthorDao {
    
    List<Author> findAll();

    public void createOrUpdate(Author a);

    public void delete(int id);

    public Author findById(Integer id);

    public List<Author> findAuthorByName(String searchName);
    
}

