package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String holdingItems;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String libraryNumber, String password, String name, String email, String phoneNumber, String holdingItems) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.holdingItems = holdingItems;
    }

    public String getLibraryNumber() { return this.libraryNumber; }
    public String getPassword() { return this.password; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public String getPhoneNumber() {return this.phoneNumber; }
    public String getHoldingItems() { return this.holdingItems; }
}
