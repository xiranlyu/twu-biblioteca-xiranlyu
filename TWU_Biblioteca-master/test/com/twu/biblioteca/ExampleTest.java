package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void viewWelcomeMessage() {
        String expectedMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(expectedMsg, newCustomer.welcome());
    }

    @Test
    public void viewListOfBooks() {
        ArrayList<Books> listOfBooks = new ArrayList<Books>();
        listOfBooks.add(new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003));
        listOfBooks.add(new Books("Effective Java", "Joshua Bloch", 2001));
        listOfBooks.add(new Books("Core Java Volume I", "Cay S. Horstmann", 2007));
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append(book.getTitle()).append("\n");
        }
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(result.toString(), newCustomer.showListOfBooks(listOfBooks));
    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {
        ArrayList<Books> listOfBooks = new ArrayList<Books>();
        listOfBooks.add(new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003));
        listOfBooks.add(new Books("Effective Java", "Joshua Bloch", 2001));
        listOfBooks.add(new Books("Core Java Volume I", "Cay S. Horstmann", 2007));
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append("title:").append(book.getTitle()).append("\b").
                    append("author:").append(book.getAuthor()).append("\b").
                    append("publication year:").append(book.getPublicationYear()).append("\n");
        }
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(result.toString(), newCustomer.viewAuthorAndPublicationYearOnAllBooks(listOfBooks));
    }
}