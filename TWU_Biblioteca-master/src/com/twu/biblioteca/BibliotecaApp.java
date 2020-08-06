package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Console console;

    public BibliotecaApp() { console = new Console(); }
    public Console getConsole() { return console; }

    public static void main(String[] args) {
        BibliotecaApp newCustomer = new BibliotecaApp();
        newCustomer.console.displayWelcomeMsg();
        newCustomer.console.userLogin();
    }
}