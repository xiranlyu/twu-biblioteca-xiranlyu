package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private final Library library;
    private final FilmArchive filmArchive;
    private final AccountManage accountManage;
    private String currentUser;
//    private List<BooksOnBorrow> borrowList = new ArrayList<>();

    public BibliotecaApp() {
        library = new Library();
        filmArchive = new FilmArchive();
        accountManage = new AccountManage();
    }

    public Library getLibrary() {
        return library;
    }
    public FilmArchive getFilmArchive() { return filmArchive; }
    public AccountManage getAccountManage() { return accountManage; }
    public String getCurrentUser() { return currentUser; }
//    public List<BooksOnBorrow> getBorrowList() { return borrowList; }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public void welcome() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
    }

    public void userLogin() {
        boolean userExists = false;
        System.out.println("Please enter your library number:");
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        for (Users user: accountManage.getUsers()) {
            if (input1.equals(user.getLibraryNumber())) {
                userExists = true;
                System.out.println("User found. Please enter your password:");
                String input2 = in.next();
                if (input2.equals(user.getPassword())) {
//                    accountManage.loginUser(input1);
                    currentUser = user.getLibraryNumber();
                    System.out.println("You have logged in : )");
                    showAMainMenuOfOptions();
                    chooseAnOption();
                    break;
                } else {
                    System.out.println("Wrong password!");
                    userLogin();
                }
            }
        }
        if (!userExists) {
            System.out.println("Wrong library number!");
            userLogin();
        }
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
        String option4 = "4 List of movies";
        String option5 = "5 Checkout a movie";
        String option6 = "6 Exit";
        menuOfOptions.add(option1);
        menuOfOptions.add(option2);
        menuOfOptions.add(option3);
        menuOfOptions.add(option4);
        menuOfOptions.add(option5);
        menuOfOptions.add(option6);
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
                showAMainMenuOfOptions();
                chooseAnOption();
                break;
            } else if (input.contains("2")) {
                checkOutBooks();
                break;
            } else if (input.contains("3")) {
                returnBooks();
                break;
            } else if (input.contains("4")) {
                showListOfMovies();
                showAMainMenuOfOptions();
                chooseAnOption();
                break;
            } else if (input.contains("5")) {
                checkOutMovies();
                break;
            } else if (input.contains("6")) {
                quitTheApplication();
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }

    private void checkOutMovies() {
        System.out.println("Please input the IMDB number of the movie to be checked out, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
        } else if (filmArchive.checkoutMovies(input)) {
            successfulCheckout();
        } else {
            unsuccessfulCheckoutAMovie();
        }
    }

    public void quitTheApplication() {
        System.exit(0);
    }

    public void checkOutBooks() {
        System.out.println("Please input the ISBN of the book to be borrowed, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
        } else if (library.checkoutBooks(input, currentUser)) {
            successfulCheckout();
        } else {
            unsuccessfulCheckoutABook();
        }
    }

    public void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book/movie.\n");
    }

    public void unsuccessfulCheckoutABook() {
        System.out.println("Sorry, that book is not available.\n");
        checkOutBooks();
    }

    public void unsuccessfulCheckoutAMovie() {
        System.out.println("Sorry, that movie is not available.\n");
        checkOutMovies();
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

    public String getBorrowHistory(String libraryNumber) {
        if (currentUser != null && currentUser.equals("admin")) {
            return library.showBorrowedBooks(libraryNumber);
        } else {
            System.out.println("You are not authorized to view this.");
            return "You are not authorized to view this.";
        }
    }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.welcome();
        newCustomer.userLogin();
        newCustomer.getBorrowHistory("admin");
    }
}
