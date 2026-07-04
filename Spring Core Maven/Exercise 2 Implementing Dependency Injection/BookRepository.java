package com.library.repository;

public class BookRepository {

    public void saveBook(String bookName) {
        System.out.println("[Repository] Saving book: " + bookName);
    }

    public String findBook(String bookName) {
        System.out.println("[Repository] Finding book: " + bookName);
        return "Found: " + bookName;
    }

    public void deleteBook(String bookName) {
        System.out.println("[Repository] Deleting book: " + bookName);
    }
}
