package com.example.ebook;

import java.util.Scanner;

public class ReaderApp {

    public static void main(String[] args) {
        ReaderApp app = new ReaderApp();
        app.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== E-Book Reader (Bridge Pattern Demo) ===");

            // loop until user explicitly chooses exit
            boolean exitRequested = false;
            do {
                exitRequested = showMenu(scanner);
            } while (!exitRequested);

            System.out.println("Goodbye!");
        }
    }

    private boolean showMenu(Scanner scanner) {
        System.out.println("\nChoose book type: 1) Novel  2) Textbook  3) Comic  4) Exit");
        String choice = scanner.nextLine().trim();

        if ("4".equals(choice)) {
            return true; // user requested exit
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        System.out.println("Choose format: 1) PDF  2) EPUB  3) MOBI");
        String formatChoice = scanner.nextLine().trim();

        Format format;
        switch (formatChoice) {
            case "1": format = new PDFFormat(); break;
            case "2": format = new EPUBFormat(); break;
            case "3": format = new MOBIFormat(); break;
            default:
                System.out.println("Invalid format. Try again.");
                return false;
        }

        EBook book;
        switch (choice) {
            case "1": book = new Novel(title, format); break;
            case "2": book = new Textbook(title, format); break;
            case "3": book = new Comic(title, format); break;
            default:
                System.out.println("Invalid book type. Try again.");
                return false;
        }

        book.read();
        return false; // keep running unless explicitly exited
    }
}
