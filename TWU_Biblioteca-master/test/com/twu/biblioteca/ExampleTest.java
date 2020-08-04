package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

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
    public void checkoutABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getLibrary().checkoutBooks("9780134177304", "admin");
        assertEquals(3, newCustomer.getLibrary().getQuantityOfBook("9780134177304"));
    }

    @Test
    public void returnABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getLibrary().checkoutBooks("9780132345286", "admin");
        newCustomer.getLibrary().returnBooks("9780132345286");
        assertEquals(5, newCustomer.getLibrary().getQuantityOfBook("9780132345286"));
    }

    @Test
    public void viewMovieList() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals("title: Interstellar director: Christopher Nolan year: 2014 rating: 9.4 IMDB: 0816692\n" +
                "title: Billy Lynn's Long Halftime Walk director: Ang Lee year: 2016 rating: 8.4 IMDB: 2513074\n" +
                "title: 1917 director: Sam Mendes year: 2019 rating: 8.5 IMDB: 8579674\n", newCustomer.showListOfMovies());
    }

    @Test
    public void checkoutAMovie() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getFilmArchive().checkoutMovies("2513074");
        assertEquals(0, newCustomer.getFilmArchive().getQuantityOfMovie("2513074"));
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