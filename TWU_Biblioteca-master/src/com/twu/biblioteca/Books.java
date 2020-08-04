package com.twu.biblioteca;

public class Books {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private int quantity;

    public Books(String title, String author, int publicationYear, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPublicationYear(){
        return this.publicationYear;
    }

    public String getIsbn() { return this.isbn; }

    public int getQuantity() { return this.quantity; }

    public void setQuantity(int num) { this.quantity = num; }

}
