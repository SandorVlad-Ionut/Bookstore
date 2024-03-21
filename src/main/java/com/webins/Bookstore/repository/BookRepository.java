package com.webins.Bookstore.repository;

import com.webins.Bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(String author);
    List<Book> findByName(String name);
    List<Book> findByPrice(double price);
    List<Book> findByYear(int year);
    List<Book> findByGenre(String genre);



}
