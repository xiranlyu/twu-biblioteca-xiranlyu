package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private Books headFirstJava = new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003);
    private Books effectiveJava = new Books("Effective Java", "Joshua Bloch", 2001);
    private Books coreJava = new Books("Core Java Volume I", "Cay S. Horstmann", 2007);

    @Test
    public void viewWelcomeMessage() {
        String expectedMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(expectedMsg, newCustomer.welcome());
    }

    @Test
    public void viewListOfBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.addBooks(headFirstJava);
        newCustomer.addBooks(effectiveJava);
        newCustomer.addBooks(coreJava);
        assertEquals("Head First Java\nEffective Java\nCore Java Volume I\n", newCustomer.showListOfBooks());
    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.addBooks(headFirstJava);
        newCustomer.addBooks(effectiveJava);
        newCustomer.addBooks(coreJava);
        ArrayList<Books> books = new ArrayList<Books>();
        books.add(headFirstJava);
        books.add(effectiveJava);
        books.add(coreJava);
        StringBuilder result = new StringBuilder();
        for (Books book: books) {
            result.append("title: ").append(book.getTitle()).
                    append(" author: ").append(book.getAuthor()).
                    append(" publication year: ").append(book.getPublicationYear()).append("\n");
        }
        assertEquals(result.toString(), newCustomer.viewAuthorAndPublicationYearOnAllBooks());
    }

    @Test
    public void viewAMainMenuOfOptions() {
//        ArrayList<String> menuOfOptions = new ArrayList<String>();
        String option1 = "List of books\n";
        String option2 = "Exit\n";
//        menuOfOptions.add(option1);
//        menuOfOptions.add(option2);
//        StringBuilder menu = new StringBuilder();
//        for (String option: menuOfOptions) {
//            menu.append(option);
//        }
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(option1 + option2, newCustomer.showAMainMenuOfOptions());
    }
}