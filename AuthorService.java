/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entities.Author;
import java.util.List;

/**
 *
 * @author andpa
 */
public interface AuthorService {
    
    List<Author> getAllAuthors();

    public void createOrUpdateAuthor(Author a);

    public void deleteAuthor(int id);

    public Author findAuthorById(Integer id);

    public List<Author> findAuthorByName(String searchName);
    
    
}
