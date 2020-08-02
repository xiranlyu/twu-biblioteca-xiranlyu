package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {
    public String welcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showListOfBooks(ArrayList<String> listOfBooks){
        StringBuilder result = new StringBuilder();
        for (String book: listOfBooks) {
            result.append(book).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
    }
}