package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void ShowWelcomeMessage() {
        String expectedMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        BibliotecaApp newCustomer = new BibliotecaApp();
        assertEquals(expectedMsg, newCustomer.welcome());
    }
}