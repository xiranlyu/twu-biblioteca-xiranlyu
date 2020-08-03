package com.twu.biblioteca;

public class Books {
    private String title;
    private String author;
    private int publicationYear;

    public Books(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
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
}
