/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.Dao.AuthorDao;
import com.mycompany.entities.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andpa
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao adao;

    @Override
    public List<Author> getAllAuthors() {
        return adao.findAll();
    }

    @Override
    public void createOrUpdateAuthor(Author a) {
       adao.createOrUpdate(a);
    }

    @Override
    public void deleteAuthor(int id) {
        adao.delete(id);
    }

    @Override
    public Author findAuthorById(Integer id) {
       return adao.findById(id);
    }

    @Override
    public List<Author> findAuthorByName(String searchName) {
  List<Author> list = adao.findAuthorByName(searchName);
        return list;
    }

}
