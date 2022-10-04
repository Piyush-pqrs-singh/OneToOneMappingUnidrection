package com.exampleJDBC.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private float price;
 
    protected Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
 
    protected Book() {
    }
 
 
    @Override
    public String toString() {
        return "Book [" + title + ", " + author + ", $" + price + "]";
    }
 
    // getters and setters...

}
