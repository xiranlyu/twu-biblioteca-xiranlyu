package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private List<Books> books = new ArrayList<>(Arrays.asList(new Books("Head First Java", "Kathy Sierra, Bert Bates", 2003,
            "9780596004651", 5), new Books("Effective Java", "Joshua Bloch", 2001,
            "9780132345286", 5), new Books("Core Java Volume I", "Cay S. Horstmann", 2007,
            "9780134177304", 4)));

    private List<BooksOnBorrow> borrowedBooks = new ArrayList<>();

    public String showBorrowedBooks(String user) {
        StringBuilder result = new StringBuilder();
        for (BooksOnBorrow borrowedBook: borrowedBooks) {
            if (user.equals(borrowedBook.getLibraryNumber())) {
                result.append("libraryNumber: ").append(user).
                        append(" borrowed: ").append(borrowedBook.getTitle()).
                        append(" isbn: ").append(borrowedBook.getIsbn()).
                        append(" number of borrow: ").append(borrowedBook.getQuantity());
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public int getQuantityOfBook(String isbn) {
        for (Books book: books) {
            if (book.getIsbn().equals(isbn)) {
                return book.getQuantity();
            }
        }
        return -1;
    }

    public String showListOfBooks() {
        StringBuilder list = new StringBuilder();
        for (Books book : books) {
            list.append(book.getTitle()).append("\n");
        }
        System.out.println(list.toString());
        return list.toString();
    }

    public String showAuthorAndPublicationYearOnAllBooks() {
        StringBuilder result = new StringBuilder();
        for (Books book : books) {
            result.append("title: ").append(book.getTitle()).
                    append(" author: ").append(book.getAuthor()).
                    append(" publication year: ").append(book.getPublicationYear()).append("\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public boolean checkoutBooks(String isbn, String user) {
        for (Books book: books) {
            if (isbn.equals(book.getIsbn()) && book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                borrowedBooks.add(new BooksOnBorrow(user, book.getTitle(), isbn, 1));
                return true;
            }
        }
        return false;
    }

    public boolean returnBooks(String isbn) {
        for (Books book: books) {
            if (isbn.equals(book.getIsbn())) {
                book.setQuantity(book.getQuantity() + 1);
                return true;
            }
        }
        return false;
    }
}
