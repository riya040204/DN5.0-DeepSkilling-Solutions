package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] BookRepository injected via Constructor!");
    }

    // Default constructor needed for Setter Injection
    public BookService() {
        System.out.println("[BookService] Created with default constructor.");
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] BookRepository injected via Setter!");
    }

    public void addBook(String bookName) {
        System.out.println("[BookService] Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }

    public void searchBook(String bookName) {
        System.out.println("[BookService] Searching: " + bookName);
        String result = bookRepository.findBook(bookName);
        System.out.println("[BookService] Result: " + result);
    }

    public void removeBook(String bookName) {
        System.out.println("[BookService] Removing: " + bookName);
        bookRepository.deleteBook(bookName);
    }
}
