package com.example.ecommerce;

import java.util.Scanner;

public class EcommerceApp {

    public static void main(String[] args) {
        EcommerceApp app = new EcommerceApp();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== E-Commerce Observer Demo ===");

        Product product = new Product("Gaming Laptop");

        boolean exitRequested;
        do {
            exitRequested = showMenu(scanner, product);
        } while (!exitRequested);

        System.out.println("Goodbye!");
        scanner.close();
    }

    private boolean showMenu(Scanner scanner, Product product) {
        System.out.println("\nMenu:");
        System.out.println("1) Subscribe to notifications");
        System.out.println("2) Restock product");
        System.out.println("3) Exit");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Choose notification type (EMAIL/SMS): ");
                String typeStr = scanner.nextLine().trim().toUpperCase();
                NotificationType type = NotificationType.valueOf(typeStr);
                Customer customer = new Customer(name, type);
                product.subscribe(customer);
                return false;

            case "2":
                product.restock();
                return false;

            case "3":
                return true;

            default:
                System.out.println("Invalid choice. Try again.");
                return false;
        }
    }
}
