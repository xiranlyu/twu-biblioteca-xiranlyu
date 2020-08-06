package com.twu.biblioteca;

import java.util.Scanner;

public class Console {
    private final Library library;
    private final FilmArchive filmArchive;
    private final AccountManage accountManage;
    private String currentUser;

    public Console()  {
        library = new Library();
        filmArchive = new FilmArchive();
        accountManage = new AccountManage();
    }

    public String getCurrentUser() { return currentUser; }
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    public Library getLibrary(){ return library; }
    public FilmArchive getFilmArchive() { return filmArchive; }

    public void displayWelcomeMsg() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void userLogin() {
        boolean userExists = false;
        System.out.println("Please enter your library number:");
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        for (User user: accountManage.getUsers()) {
            if (input1.equals(user.getLibraryNumber())) {
                userExists = true;
                System.out.println("User found. Please enter your password:");
                String input2 = in.next();
                if (input2.equals(user.getPassword())) {
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

    private void prompt() {
        System.out.println("Please enter the number to choose:");
    }

    public String showListOfMovies(){ return filmArchive.showMovieList(); }

    public String viewAuthorAndPublicationYearOnAllBooks(){ return library.showAuthorAndPublicationYearOnAllBooks(); }

    Command[] commands = {
            new Command("0 Back to menu") {
                @Override public void execute() {
                    showAMainMenuOfOptions();
                    chooseAnOption();
                }
            },
            new Command("1 List of books") {
                @Override public void execute() {
                    library.showAuthorAndPublicationYearOnAllBooks();
                    showAMainMenuOfOptions();
                    chooseAnOption();
                }
            },
            new Command("2 Checkout a book") {
                @Override public void execute() {
                    checkOutBooks();
                }
            },
            new Command("3 Return a book") {
                @Override public void execute() {
                    returnBooks();
                }
            },
            new Command("4 List of movies") {
                @Override public void execute() {
                    showListOfMovies();
                    showAMainMenuOfOptions();
                    chooseAnOption();
                }
            },
            new Command("5 Checkout a movie") {
                @Override public void execute() {
                    checkOutMovies();
                }
            },
            new Command("6 View my info") {
                @Override public void execute() {
                    accountManage.showUserInfo(currentUser);
                    showAMainMenuOfOptions();
                    chooseAnOption();
                }
            },
            new Command("7 View borrow history") {
                @Override public void execute() {
                    getBorrowHistory(getCurrentUser());
                    showAMainMenuOfOptions();
                    chooseAnOption();
                }
            },
            new Command("8 Exit") {
                @Override public void execute() {
                    quitTheApplication();
                }
            }
    };

    public void showAMainMenuOfOptions() {
        for (Command command: commands) {
            System.out.println(command);
        }
    }

    private void chooseAnOption() {
        prompt();
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input > 8 || input < 0) {
            System.out.println("This is an invalid option!");
            showAMainMenuOfOptions();
            chooseAnOption();
        } else {
            commands[input].execute();
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
            chooseAnOption();
            showAMainMenuOfOptions();
        } else {
            unsuccessfulCheckoutAMovie();
        }
    }

    private void checkOutBooks() {
        System.out.println("Please input the ISBN of the book to be borrowed, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
        } else if (checkoutBooks(input, currentUser)) {
            successfulCheckout();
        } else {
            unsuccessfulCheckoutABook();
        }
    }

    public boolean checkoutBooks(String input, String currentUser) {
        String title = "";
        for (Book book: library.getBooks()) {
            if (input.equals(book.getIsbn()) && book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                title = book.getTitle();
            }
        }
        for (User user: accountManage.getUsers()) {
            if (currentUser.equals(user.getLibraryNumber())) {
                accountManage.getUserRecord().add(
                        new User(currentUser, user.getPassword(), user.getName(), user.getEmail(), user.getPhoneNumber(), title));
                return true;
            }
        }
        return false;
    }

    private void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book/movie.\n");
        showAMainMenuOfOptions();
        chooseAnOption();
    }

    private void unsuccessfulCheckoutABook() {
        System.out.println("Sorry, that book is not available.\n");
        checkOutBooks();
    }

    private void unsuccessfulCheckoutAMovie() {
        System.out.println("Sorry, that movie is not available.\n");
        checkOutMovies();
    }

    private void returnBooks() {
        System.out.println("Please input the ISBN of the book to be returned, or input 0 to see the main menu: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (input.equals("0")) {
            showAMainMenuOfOptions();
            chooseAnOption();
        } else if (returnBooks(input)) {
            successfulReturn();
            showAMainMenuOfOptions();
            chooseAnOption();
        } else {
            unsuccessfulReturn();
        }
    }

    public boolean returnBooks(String isbn) {
        for (Book book: library.getBooks()) {
            if (isbn.equals(book.getIsbn())) {
                book.setQuantity(book.getQuantity() + 1);
                return true;
            }
        }
        return false;
    }

    private void successfulReturn() {
        System.out.println("Thank you for returning the book\n");
    }

    private void unsuccessfulReturn() {
        System.out.println("That is not a valid book to return.\n");
        returnBooks();
    }

    public String getBorrowHistory(String libraryNumber) {
        if (currentUser != null && currentUser.equals("admin")) {
            return accountManage.showRecord(libraryNumber);
        } else {
            System.out.println("You are not authorized to view this.");
            return "You are not authorized to view this.";
        }
    }

    public String showUserInfo() {
        if (currentUser != null) {
            return accountManage.showUserInfo(currentUser);
        }
        return null;
    }

    private void quitTheApplication(){ System.exit(0); }
}
