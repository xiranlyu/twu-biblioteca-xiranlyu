package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public String welcome() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
        return welcomeMsg;
    }

    public String showListOfBooks(ArrayList<Books> listOfBooks){
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append(book.getTitle()).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public String viewAuthorAndPublicationYearOnAllBooks(ArrayList<Books> listOfBooks){
        StringBuilder result = new StringBuilder();
        for (Books book: listOfBooks) {
            result.append("title: ").append(book.getTitle()).
                    append(" author: ").append(book.getAuthor()).
                    append(" publication year: ").append(book.getPublicationYear()).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public String showAMainMenuOfOptions() {
        ArrayList<String> menuOfOptions = new ArrayList<String>();
        String option1 = "List of books";
        String option2 = "Exit";
        menuOfOptions.add(option1);
        menuOfOptions.add(option2);
        StringBuilder result = new StringBuilder();
        for (String option: menuOfOptions) {
            result.append(option).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public void chooseAnOption(ArrayList<Books> listOfBooks){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String input = in.nextLine();
            if (input.equals("List of books")) {
                showListOfBooks(listOfBooks);
                break;
            } else if (input.equals("Exit")) {
                quitTheApplication();
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }

    public void quitTheApplication() {
        System.exit(0);
    }

    public static void main(String[] args) {
        ArrayList<Books> listOfBooks = new ArrayList<Books>();
        listOfBooks.add(new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003));
        listOfBooks.add(new Books("Effective Java", "Joshua Bloch", 2001));
        listOfBooks.add(new Books("Core Java Volume I", "Cay S. Horstmann", 2007));

        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
        newCustomer.showAMainMenuOfOptions();
        newCustomer.chooseAnOption(listOfBooks);
    }
}