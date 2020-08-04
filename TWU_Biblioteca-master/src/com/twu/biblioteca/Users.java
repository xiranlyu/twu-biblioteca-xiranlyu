package com.twu.biblioteca;

import java.util.HashMap;

public class Users {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean status = false;
    private String onHoldItems;

    public Users(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() { return this.libraryNumber; }
    public String getPassword() { return this.password; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    public String getPhoneNumber() {return this.phoneNumber; }
    public void setStatus() { this.status = !this.status; }
    public String getOnHoldItems() { return this.onHoldItems; }
}
