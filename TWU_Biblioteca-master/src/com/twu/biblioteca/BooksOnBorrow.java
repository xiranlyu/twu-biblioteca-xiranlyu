package com.twu.biblioteca;

public class BooksOnBorrow {
    private String libraryNumber;
    private String title;
    private String isbn;
    private int quantity;

    public BooksOnBorrow(String libraryNumber, String title, String isbn, int quantity) {
        this.libraryNumber = libraryNumber;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }
}
