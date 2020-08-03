package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    public String welcome() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showListOfBooks(ArrayList<Books> listOfBooks){
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append(book.getTitle()).append("\n");
        }
        return result.toString();
    }

    public String viewAuthorAndPublicationYearOnAllBooks(ArrayList<Books> listOfBooks){
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append("title:").append(book.getTitle()).append("\b").
                    append("author:").append(book.getAuthor()).append("\b").
                    append("publication year:").append(book.getPublicationYear()).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
    }
}