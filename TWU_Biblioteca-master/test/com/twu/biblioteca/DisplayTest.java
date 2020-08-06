package com.twu.biblioteca;

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
        newCustomer.getConsole().displayWelcomeMsg();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("title: Head First Java author: Kathy Sierra, Bert Bates publication year: 2003 ISBN: 9780596004651\n" +
                "title: Effective Java author: Joshua Bloch publication year: 2001 ISBN: 9780132345286\n" +
                "title: Core Java Volume I author: Cay S. Horstmann publication year: 2007 ISBN: 9780134177304\n",
                newCustomer.getConsole().viewAuthorAndPublicationYearOnAllBooks());
    }

    @Test
    public void viewAMainMenuOfOptions() {
        String option0 = "0 Back to menu\n";
        String option1 = "1 List of books\n";
        String option2 = "2 Checkout a book\n";
        String option3 = "3 Return a book\n";
        String option4 = "4 List of movies\n";
        String option5 = "5 Checkout a movie\n";
        String option6 = "6 View my info\n";
        String option7 = "7 View borrow history\n";
        String option8 = "8 Exit\n";
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().showAMainMenuOfOptions();
        assertEquals(option0 + option1 + option2 + option3 + option4 + option5 + option6 + option7 + option8,
                outContent.toString());
    }

    @Test
    public void viewMovieList() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("title: Interstellar director: Christopher Nolan year: 2014 rating: 9.4 IMDB: 0816692\n" +
                "title: Billy Lynn's Long Halftime Walk director: Ang Lee year: 2016 rating: 8.4 IMDB: 2513074\n" +
                "title: 1917 director: Sam Mendes year: 2019 rating: 8.5 IMDB: 8579674\n", newCustomer.getConsole().showListOfMovies());
    }

    @Test
    public void viewBooksOnBorrow() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().setCurrentUser("admin");
        newCustomer.getConsole().checkoutBooks("9780596004651", "admin");
        assertEquals("libraryNumber: admin name: admin borrowed: Head First Java",
                newCustomer.getConsole().getBorrowHistory("admin"));
    }

    @Test
    public void viewUserInfo() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().setCurrentUser("admin");
        assertEquals("name: admin email: admin@biblioteca.com phone number: 00000000000",
                newCustomer.getConsole().showUserInfo());
    }
}