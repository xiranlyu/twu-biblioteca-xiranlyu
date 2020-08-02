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
        ArrayList<String> listOfBooks = new ArrayList<String>();
        listOfBooks.add("Head First Java");
        listOfBooks.add("Effective Java");
        listOfBooks.add("Core Java");
        StringBuilder result = new StringBuilder();
        for (String book: listOfBooks) {
            result.append(book).append("\n");
        }
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(result.toString(), newCustomer.showListOfBooks(listOfBooks));
    }
}