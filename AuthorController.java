/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.entities.Author;
import com.mycompany.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author andpa
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    AuthorService service;
    
    @GetMapping("/list")
    public String showCustomers(Model m){
        
        List<Author> list = service.getAllAuthors();
        m.addAttribute("listOfAuthors", list);
        return "listAuthor";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("author") Author a){
        return "formAuthor";
    }
    
    
    @PostMapping("/create")
    public String createOrUpdateAuthor(Author a){
        service.createOrUpdateAuthor(a);
        return "redirect:/author/list";
    }
    
    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("author_id") int id){
        service.deleteAuthor(id);
        return "redirect:/author/list";
    }
    
    @GetMapping("/update")
    public String showUpdateForm(
            @RequestParam("author_id") Integer id, Model model
    ){
        Author a = service.findAuthorById(id);
        model.addAttribute("author", a);
        return "formAuthor";
    }
    
    @GetMapping("/search")
    public String showAuthorByName(
            @RequestParam("searchName") String searchName, Model model){
        List<Author> list = service.findAuthorByName(searchName);
        model.addAttribute("listOfAuthtor", list);
        return "listAuthor";
    }
    
}
