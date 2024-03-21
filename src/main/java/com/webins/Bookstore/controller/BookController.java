package com.webins.Bookstore.controller;

import com.webins.Bookstore.entity.Book;
import com.webins.Bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookstoreService bookstoreService;

    @Autowired
    public BookController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookstoreService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookstoreService.findBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        bookstoreService.saveBook(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        bookstoreService.updateBook(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookstoreService.deleteBook(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}