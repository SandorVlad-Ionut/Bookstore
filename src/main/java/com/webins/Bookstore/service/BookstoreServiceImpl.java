package com.webins.Bookstore.service;

import com.webins.Bookstore.entity.Book;
import com.webins.Bookstore.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService{

    private final BookRepository repo;

    public BookstoreServiceImpl(BookRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Book> findAllBooks() {
        return repo.findAll();
    }

    @Override
    public Book findBookById(int id) {
        return repo.findById(id).orElse(null);
    }




    @Override
    public void saveBook(Book book) {
        repo.save(book);
    }


    @Override
    @Transactional
    public void updateBook(int id, Book book) {
        Book existingBook = repo.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setName(book.getName());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setGenre(book.getGenre());
            existingBook.setPrice(book.getPrice());
            existingBook.setYear(book.getYear());
            repo.save(existingBook);
        }}

    @Override
    public void deleteBook(int id) {
        repo.deleteById(id);

    }

    @PostConstruct
    public void initData() {
        {
            saveBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 15.99, 1925));
            saveBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 10.99, 1960));
            saveBook(new Book("1984", "George Orwell", "Fiction", 12.99, 1949));
            saveBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 11.99, 1951));
            saveBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 14.99, 1937));
            saveBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 19.99, 1954));
            saveBook(new Book("The Da Vinci Code", "Dan Brown", "Mystery", 13.99, 2003));

        }

    }


}
