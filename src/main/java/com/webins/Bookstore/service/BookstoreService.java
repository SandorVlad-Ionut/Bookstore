package com.webins.Bookstore.service;

import com.webins.Bookstore.entity.Book;
import com.webins.Bookstore.repository.BookRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookstoreService{

    List<Book> findAllBooks();
    Book findBookById(int id);


    void saveBook(Book book);

    void deleteBook(int id);

    void updateBook(int id, Book book);

    public void initData() ;}
