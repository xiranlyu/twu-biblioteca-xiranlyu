package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void displayWelcomeMsg() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }

    @Test
    public void viewListOfBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("Head First Java\nEffective Java\nCore Java Volume I\n", newCustomer.showListOfBooks());
    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("title: Head First Java author: Kathy Sierra, Bert Bates publication year: 2003\n" +
                "title: Effective Java author: Joshua Bloch publication year: 2001\n" +
                "title: Core Java Volume I author: Cay S. Horstmann publication year: 2007\n", newCustomer.viewAuthorAndPublicationYearOnAllBooks());
    }

    @Test
    public void viewAMainMenuOfOptions() {
        String option1 = "1 List of books\n";
        String option2 = "2 Checkout a book\n";
        String option3 = "3 Return a book\n";
        String option4 = "4 List of movies\n";
        String option5 = "5 Checkout a movie\n";
        String option6 = "6 View my info\n";
        String option7 = "7 Exit\n";
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(option1 + option2 + option3 + option4 + option5 + option6 + option7,
                newCustomer.showAMainMenuOfOptions());
    }

    @Test
    public void viewMovieList() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("title: Interstellar director: Christopher Nolan year: 2014 rating: 9.4 IMDB: 0816692\n" +
                "title: Billy Lynn's Long Halftime Walk director: Ang Lee year: 2016 rating: 8.4 IMDB: 2513074\n" +
                "title: 1917 director: Sam Mendes year: 2019 rating: 8.5 IMDB: 8579674\n", newCustomer.showListOfMovies());
    }

    @Test
    public void viewBooksOnBorrow() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.setCurrentUser("admin");
        newCustomer.getLibrary().checkoutBooks("9780596004651", "admin");
        assertEquals("libraryNumber: admin borrowed: Head First Java isbn: 9780596004651 number of borrow: 1",
                newCustomer.getBorrowHistory("admin"));
    }

    @Test
    public void viewUserInfo() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.setCurrentUser("admin");
        assertEquals("name: admin email: admin@biblioteca.com phone number: 00000000000",
                newCustomer.showUserInfo());
    }
}