package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Library library;

    public BibliotecaApp() {
        library = new Library();
    }

    public void welcome() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
    }

    public String showListOfBooks(){
        return library.showListOfBooks();
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
        System.out.println("Please input the number of options to choose");
        chooseAnOption();
        return result.toString();
    }

    public void chooseAnOption(){
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
//                returnBooks();
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
        System.out.println("Please input the ISBN of the book to be borrowed:");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        for (Books book: library.getBooks()) {
            if (input.equals(book.getIsbn()) && book.getQuantity() != 0) {
                book.setQuantity(book.getQuantity() - 1);
                successfulCheckout();
                System.out.println(book.getQuantity() + " of this book left\n");
                showAMainMenuOfOptions();
                return true;
            }
        }
        unsuccessfulCheckout();
        return false;
    }

    public void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book\n");
    }

    public void unsuccessfulCheckout() {
        System.out.println("Sorry, that book is not available\n");
        checkOutBooks();
    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
        newCustomer.showAMainMenuOfOptions();
    }
}
