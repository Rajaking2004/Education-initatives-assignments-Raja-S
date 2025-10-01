package com.example.ebook;

import java.util.Scanner;

public class ReaderApp {

    public static void main(String[] args) {
        ReaderApp app = new ReaderApp();
        app.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            InMemoryLogger.info("E-Book Reader started.");
            System.out.println("=== E-Book Reader (Bridge Pattern Demo) ===");

            boolean exitRequested = false;
            do {
                exitRequested = showMenu(scanner);
            } while (!exitRequested);

            InMemoryLogger.info("E-Book Reader terminated.");
            System.out.println("Goodbye!");

            // Optional: print all logs at the end
            System.out.println("\n=== Log History ===");
            for (String log : InMemoryLogger.getLogs()) {
                System.out.println(log);
            }
        }
    }

    private boolean showMenu(Scanner scanner) {
        System.out.println("\nChoose book type: 1) Novel  2) Textbook  3) Comic  4) Exit");
        String choice = scanner.nextLine().trim();

        if ("4".equals(choice)) {
            InMemoryLogger.info("User requested exit.");
            return true; // exit
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            InMemoryLogger.warn("Book title cannot be empty.");
            return false;
        }

        System.out.println("Choose format: 1) PDF  2) EPUB  3) MOBI");
        String formatChoice = scanner.nextLine().trim();

        Format format;
        switch (formatChoice) {
            case "1": format = new PDFFormat(); break;
            case "2": format = new EPUBFormat(); break;
            case "3": format = new MOBIFormat(); break;
            default:
                InMemoryLogger.warn("Invalid format selected: " + formatChoice);
                System.out.println("Invalid format. Try again.");
                return false;
        }

        EBook book;
        switch (choice) {
            case "1": book = new Novel(title, format); break;
            case "2": book = new Textbook(title, format); break;
            case "3": book = new Comic(title, format); break;
            default:
                InMemoryLogger.warn("Invalid book type selected: " + choice);
                System.out.println("Invalid book type. Try again.");
                return false;
        }

        InMemoryLogger.info("Reading book: " + title + " as " + format.getClass().getSimpleName());
        book.read();
        return false;
    }
}
