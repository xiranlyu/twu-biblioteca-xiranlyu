package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private List<Books> books = new ArrayList<>();
//
//    public List<Books> getBooks() {
//        return books;
//    }

    public void addBooks(Books book) {
        books.add(book);
    }

//    public void addAll(Books ...books) {
//        this.books.addAll(Arrays.asList(books));
//    }

    public String showListOfBooks() {
        StringBuilder list = new StringBuilder();
        for(Books book: books) {
            list.append(book.getTitle()).append("\n");
        }
        System.out.println(list.toString());
        return list.toString();
    }

    public String showAuthorAndPublicationYearOnAllBooks() {
        StringBuilder result = new StringBuilder();
        for (Books book: books) {
            result.append("title: ").append(book.getTitle()).
                    append(" author: ").append(book.getAuthor()).
                    append(" publication year: ").append(book.getPublicationYear()).append("\n");
        }
        return result.toString();
    }

}
