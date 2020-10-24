package com.api.book.bootrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "writer")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int writer_id;
    private String firstName;
    private String lastName;
    private String langauge;

    @OneToOne(mappedBy = "writer") // mappedBy se hum ne book wale variable ko bta diya hai ki foreign key ki mapping "writer"  name ka variable kr rha hai so usko nhi krni hai
    @JsonBackReference  //iska use kr k humne infinity loop tode de hai is annotation ko use kr k humne isko bta diya hai ki back na jaye means book ka json ready na kre book pe na jaye restristion lga di ek trha se
    private Book book;


    public Writer(int writer_id, String firstName, String lastName, String langauge) {
        this.writer_id = writer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.langauge = langauge;
    }

    public Writer() {
    }
    

    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLangauge() {
        return langauge;
    }

    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }

   

   

    
}
