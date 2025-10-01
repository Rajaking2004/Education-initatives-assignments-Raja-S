package com.example.watch;

import java.util.Scanner;

public class WatchFactoryApp {

    public static void main(String[] args) {
        WatchFactoryApp app = new WatchFactoryApp();
        app.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            InMemoryLogger.info("Watch Factory started.");

            boolean exitRequested = false;
            do {
                try {
                    exitRequested = showMenu(scanner);
                } catch (Exception e) {
                    InMemoryLogger.error("Unexpected error: " + e.getMessage());
                    // Transient error handling: continue loop
                    System.out.println("An error occurred. Please try again.");
                }
            } while (!exitRequested);

            InMemoryLogger.info("Watch Factory terminated.");
            System.out.println("Exiting Watch Factory. Goodbye!");

            // Optional: print logs at the end
            System.out.println("\n=== Log History ===");
            for (String log : InMemoryLogger.getLogs()) {
                System.out.println(log);
            }
        }
    }

    private boolean showMenu(Scanner scanner) {
        System.out.println("\n=== Watch Factory Menu ===");
        System.out.println("Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.isEmpty()) {
            InMemoryLogger.warn("No input provided.");
            return false;
        }

        if ("4".equals(choice)) {
            InMemoryLogger.info("User requested exit.");
            return true;
        }

        Watch watch = null;

        try {
            switch (choice) {
                case "1": watch = WatchFactory.createWatch("digital"); break;
                case "2": watch = WatchFactory.createWatch("analog"); break;
                case "3": watch = WatchFactory.createWatch("smart"); break;
                default:
                    InMemoryLogger.warn("Invalid watch type selected: " + choice);
                    System.out.println("Invalid choice. Try again.");
                    return false;
            }

            if (watch != null) {
                InMemoryLogger.info("Created watch: " + watch.getClass().getSimpleName());
                watch.showTime();
            }
        } catch (Exception e) {
            InMemoryLogger.error("Failed to create watch: " + e.getMessage());
            System.out.println("Error creating watch. Please try again.");
        }

        return false;
    }
}
