package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Library library;
    private FilmArchive filmArchive;

    public Library getLibrary() {
        return library;
    }

    public BibliotecaApp() {
        library = new Library();
        filmArchive = new FilmArchive();
    }

    public void welcome() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
    }

    public String showListOfBooks(){
        return library.showListOfBooks();
    }

    public String showListOfMovies(){
        return filmArchive.showMovieList();
    }

    public String viewAuthorAndPublicationYearOnAllBooks(){
        return library.showAuthorAndPublicationYearOnAllBooks();
    }

    public String showAMainMenuOfOptions() {
        ArrayList<String> menuOfOptions = new ArrayList<String>();
        String option1 = "1 List of books";
        String option2 = "2 Checkout a book";
        String option3 = "3 Return a book";
        String option4 = "4 Exit";
        menuOfOptions.add(option1);
        menuOfOptions.add(option2);
        menuOfOptions.add(option3);
        menuOfOptions.add(option4);
        StringBuilder result = new StringBuilder();
        for (String option: menuOfOptions) {
            result.append(option).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public void chooseAnOption(){
        System.out.println("Please input the number of options to choose");
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String input = in.nextLine();
            if (input.contains("1")) {
                showListOfBooks();
                break;
            } else if (input.contains("2")) {
                checkOutBooks();
                break;
            } else if (input.contains("3")) {
                returnBooks();
                break;
            } else if (input.contains("4")) {
                quitTheApplication();
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }

    public void quitTheApplication() {
        System.exit(0);
    }

    public boolean checkOutBooks() {
        System.out.println("Please input the ISBN of the book to be borrowed, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
            return false;
        } else if (library.checkoutBooks(input)) {
            successfulCheckout();
            showAMainMenuOfOptions();
            chooseAnOption();
            return true;
        } else {
            unsuccessfulCheckout();
            return false;
        }
    }

    public void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book.\n");
    }

    public void unsuccessfulCheckout() {
        System.out.println("Sorry, that book is not available.\n");
        checkOutBooks();
    }

    public boolean returnBooks() {
        System.out.println("Please input the ISBN of the book to be returned, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
            return false;
        } else if (library.returnBooks(input)) {
            successfulReturn();
            showAMainMenuOfOptions();
            chooseAnOption();
            return true;
        } else {
            unsuccessfulReturn();
            return false;
        }
    }

    public void successfulReturn() {
        System.out.println("Thank you for returning the book\n");
    }

    public void unsuccessfulReturn() {
        System.out.println("That is not a valid book to return.\n");
        returnBooks();
    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
        newCustomer.showAMainMenuOfOptions();
        newCustomer.chooseAnOption();
        newCustomer.showListOfMovies();
    }
}
