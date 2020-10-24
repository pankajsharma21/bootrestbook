package com.api.book.bootrestbook.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    private String title;
    private String author;
    @OneToOne(cascade = CascadeType.ALL)//Cascade ka use kr k humne ne kr diya hai ki book pe operation kre to saath saath writer pe bhi ho jaye
    @JsonManagedReference // yeh annotation parents wale field pe lgaya jata hai or child wale pe @JsonBackReference  lagya jata hai is se  hum batat he ki is variable ko manage krna hai hai or back reference wale ko nhi krna taki infinity loop khtam ho ske
    private Writer writer;
    

    
    public Book(int id, String title, String author, Writer writer) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.writer = writer;
    }

    
    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", title=" + title + ", writer=" + writer + "]";
    }

    
    



}
