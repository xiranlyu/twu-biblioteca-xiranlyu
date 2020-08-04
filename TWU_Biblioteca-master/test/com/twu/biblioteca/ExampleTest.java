package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

//    @Test
//    public void viewWelcomeMessage() {
//        String expectedMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
//        BibliotecaApp newCustomer = new BibliotecaApp();
//        assertEquals(expectedMsg, newCustomer.welcome());
//    }

    @Test
    public void viewListOfBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("Head First Java\nEffective Java\nCore Java Volume I\n", newCustomer.showListOfBooks());
    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        StringBuilder result = new StringBuilder();
        assertEquals("title: Head First Java author: Kathy Sierra, Bert Bates publication year: 2003\n" +
                "title: Effective Java author: Joshua Bloch publication year: 2001\n" +
                "title: Core Java Volume I author: Cay S. Horstmann publication year: 2007\n", newCustomer.viewAuthorAndPublicationYearOnAllBooks());
    }

    @Test
    public void viewAMainMenuOfOptions() {
        String option1 = "1 List of books\n";
        String option2 = "2 Checkout a book\n";
        String option3 = "3 Return a book\n";
        String option4 = "4 Exit\n";
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(option1 + option2 + option3 + option4, newCustomer.showAMainMenuOfOptions());
    }

    @Test
    public void checkoutABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getLibrary().checkoutBooks("9780134177304");
        assertEquals(3, newCustomer.getLibrary().getQuantityOfBook("9780134177304"));
    }

    @Test
    public void returnABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getLibrary().checkoutBooks("9780132345286");
        newCustomer.getLibrary().returnBooks("9780132345286");
        assertEquals(5, newCustomer.getLibrary().getQuantityOfBook("9780132345286"));
    }
}