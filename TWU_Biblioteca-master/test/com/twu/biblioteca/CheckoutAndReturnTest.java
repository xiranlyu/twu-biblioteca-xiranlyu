package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckoutAndReturnTest {

    @Test
    public void checkoutABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().getLibrary().checkoutBooks("9780134177304", "admin");
        assertEquals(3, newCustomer.getConsole().getLibrary().getQuantityOfBook("9780134177304"));
    }

    @Test
    public void returnABook() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().getLibrary().checkoutBooks("9780132345286", "admin");
        newCustomer.getConsole().getLibrary().returnBooks("9780132345286");
        assertEquals(5, newCustomer.getConsole().getLibrary().getQuantityOfBook("9780132345286"));
    }

    @Test
    public void checkoutAMovie() {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.getConsole().getFilmArchive().checkoutMovies("2513074");
        assertEquals(0, newCustomer.getConsole().getFilmArchive().getQuantityOfMovie("2513074"));
    }

}