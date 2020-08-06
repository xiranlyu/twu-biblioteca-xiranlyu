package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library{
    private final List<Book> books = new ArrayList<>(Arrays.asList(new Book("Head First Java", "Kathy Sierra, Bert Bates", 2003,
            "9780596004651", 5), new Book("Effective Java", "Joshua Bloch", 2001,
            "9780132345286", 5), new Book("Core Java Volume I", "Cay S. Horstmann", 2007,
            "9780134177304", 4)));

    public List<Book> getBooks() {
        return books;
    }

    public int getQuantityOfBook(String isbn) {
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return book.getQuantity();
            }
        }
        return -1;
    }

    public String showAuthorAndPublicationYearOnAllBooks() {
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            result.append("title: ").append(book.getTitle()).
                    append(" author: ").append(book.getAuthor()).
                    append(" publication year: ").append(book.getPublicationYear()).
                    append(" ISBN: ").append(book.getIsbn()).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
