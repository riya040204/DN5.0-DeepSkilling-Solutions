package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter for Spring Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected successfully!");
    }

    public void addBook(String bookName) {
        System.out.println("BookService: Adding book - " + bookName);
        bookRepository.saveBook(bookName);
    }

    public void searchBook(String bookName) {
        System.out.println("BookService: Searching for - " + bookName);
        String result = bookRepository.findBook(bookName);
        System.out.println("BookService: " + result);
    }

    public void removeBook(String bookName) {
        System.out.println("BookService: Removing book - " + bookName);
        bookRepository.deleteBook(bookName);
    }
}
