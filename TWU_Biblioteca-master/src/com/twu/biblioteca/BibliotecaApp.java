package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Library library;

    public BibliotecaApp() {
        library = new Library();
    }

    public String welcome() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
        return welcomeMsg;
    }

    public void addBooks(Books book){
        library.addBooks(book);
    }

    public String showListOfBooks(){
        return library.showListOfBooks();
    }

    public String viewAuthorAndPublicationYearOnAllBooks(){
        return library.showAuthorAndPublicationYearOnAllBooks();
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

    public void chooseAnOption(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String input = in.nextLine();
            if (input.equals("List of books")) {
                library.showListOfBooks();
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

//    public boolean checkOut() {
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//
//        return true;
//    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.addBooks(new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003));
        newCustomer.addBooks(new Books("Effective Java", "Joshua Bloch", 2001));
        newCustomer.addBooks(new Books("Core Java Volume I", "Cay S. Horstmann", 2007));
        newCustomer.welcome();
        newCustomer.showAMainMenuOfOptions();
        newCustomer.chooseAnOption();
    }
}
