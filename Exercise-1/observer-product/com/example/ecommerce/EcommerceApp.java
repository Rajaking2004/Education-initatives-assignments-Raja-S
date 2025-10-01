package com.example.ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EcommerceApp {

    public static void main(String[] args) {
        EcommerceApp app = new EcommerceApp();
        app.start();
    }

    private void start() {
        InMemoryLogger.info("E-commerce Observer App started.");
        try (Scanner scanner = new Scanner(System.in)) {
            Product product = new Product("Gaming Laptop");

            boolean exitRequested = false;
            do {
                try {
                    exitRequested = showMenu(scanner, product);
                } catch (IllegalArgumentException iae) {
                    InMemoryLogger.warn("Invalid input: " + iae.getMessage());
                    System.out.println("Invalid input. Please try again.");
                } catch (InputMismatchException ime) {
                    InMemoryLogger.error("Wrong input type: " + ime.getMessage());
                    scanner.nextLine(); // clear invalid input
                } catch (Exception e) {
                    InMemoryLogger.error("Unexpected error: " + e.getMessage());
                    System.out.println("Something went wrong. Please retry.");
                    // Transient error handling → continue loop
                }
            } while (!exitRequested);

            InMemoryLogger.info("E-commerce Observer App terminated.");
            System.out.println("Goodbye!");

            // Print log history for audit
            System.out.println("\n=== LOG HISTORY ===");
            for (String log : InMemoryLogger.getLogs()) {
                System.out.println(log);
            }
        }
    }

    private boolean showMenu(Scanner scanner, Product product) {
        System.out.println("\nMenu:");
        System.out.println("1) Subscribe to notifications");
        System.out.println("2) Restock product");
        System.out.println("3) Exit");
        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine().trim();

        if (choice.isEmpty()) {
            InMemoryLogger.warn("Empty input entered for menu.");
            return false;
        }

        switch (choice) {
            case "1":
                subscribeCustomer(scanner, product);
                return false;

            case "2":
                InMemoryLogger.info("Restocking product: " + product.getName());
                product.restock();
                return false;

            case "3":
                InMemoryLogger.info("Exit requested by user.");
                return true;

            default:
                InMemoryLogger.warn("Invalid menu choice: " + choice);
                System.out.println("Invalid choice. Try again.");
                return false;
        }
    }

    private void subscribeCustomer(Scanner scanner, Product product) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            InMemoryLogger.warn("Subscription attempt with empty name.");
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Choose notification type (EMAIL/SMS): ");
        String typeStr = scanner.nextLine().trim().toUpperCase();

        try {
            NotificationType type = NotificationType.valueOf(typeStr);
            Customer customer = new Customer(name, type);
            product.subscribe(customer);
            InMemoryLogger.info("Customer subscribed: " + name + " via " + type);
        } catch (IllegalArgumentException e) {
            InMemoryLogger.warn("Invalid notification type entered: " + typeStr);
            System.out.println("Invalid notification type. Please enter EMAIL or SMS.");
        }
    }
}
