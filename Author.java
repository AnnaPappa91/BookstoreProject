/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author andpa
 */
@Entity(name = "Author")
@Table(name = "author")
@NamedQueries({
    @NamedQuery(name = "author.deleteById", query = "DELETE FROM author a WHERE a.author_id =:kwdikos")
    ,
    @NamedQuery(name = "author.findLikeName", query = "SELECT a FROM author a WHERE a.cname LIKE :name")
})
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name ="last_name")
    private String last_name;
    @Column(name ="author_biography")
    private String biography;

    public Author() {
    }

    public Author(int id, String first_name, String last_name, String biography) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.first_name);
        hash = 37 * hash + Objects.hashCode(this.last_name);
        hash = 37 * hash + Objects.hashCode(this.biography);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.biography, other.biography)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", biography=" + biography + '}';
    }

}
