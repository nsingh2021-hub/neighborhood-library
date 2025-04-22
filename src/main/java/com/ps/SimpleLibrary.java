package com.ps;

import java.util.Scanner;

class Book {
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
    }

    void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }

    void showInfo() {
        System.out.println("ID: " + id + ", Title: " + title + ", ISBN: " + isbn);
        if (isCheckedOut) {
            System.out.println(" Checked out to: " + checkedOutTo);
        }
    }
}

public class SimpleLibrary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Book[] books = new Book[3];
        books[0] = new Book(1, "1111", "Harry Potter");
        books[1] = new Book(2, "2222", "The Hobbit");
        books[2] = new Book(3, "3333", "Percy Jackson");

        while (true) {
            System.out.println("\n1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine(); // clear input

            if (choice == 1) {
                for (Book book : books) {
                    if (!book.isCheckedOut) {
                        book.showInfo();
                    }
                }

                System.out.print("Enter book ID to check out (0 to cancel): ");
                int id = input.nextInt();
                input.nextLine();

                if (id == 0) continue;

                for (Book book : books) {
                    if (book.id == id && !book.isCheckedOut) {
                        System.out.print("Your name: ");
                        String name = input.nextLine();
                        book.checkOut(name);
                        System.out.println("Book checked out!");
                    }
                }

            } else if (choice == 2) {
                for (Book book : books) {
                    if (book.isCheckedOut) {
                        book.showInfo();
                    }
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
