package com.webins.Bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    //this class creates a book object with the following attributes: id, name, author, genre, price, year

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String name;
    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;
    @Column(name = "price")
    private double price;

    @Column(name = "year")
    private int year;


    public Book(String name, String author, String genre, double price, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public void updatePrice(int id,double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }


}
