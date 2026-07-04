package com.library.repository;

public class BookRepository {

    public void saveBook(String bookName) {
        System.out.println("BookRepository: Saving book - " + bookName);
    }

    public String findBook(String bookName) {
        System.out.println("BookRepository: Finding book - " + bookName);
        return "Found: " + bookName;
    }

    public void deleteBook(String bookName) {
        System.out.println("BookRepository: Deleting book - " + bookName);
    }
}
