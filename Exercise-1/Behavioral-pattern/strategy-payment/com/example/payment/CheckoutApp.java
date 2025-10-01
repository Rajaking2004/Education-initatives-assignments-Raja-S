package com.example.payment;

import java.util.Scanner;

public class CheckoutApp {

    public static void main(String[] args) {
        new CheckoutApp().start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            InMemoryLogger.info("Checkout App started.");
            System.out.println("=== E-Commerce Checkout (Strategy Pattern) ===");

            double amount = readOrderAmount(scanner);
            Order order = new Order(amount);

            boolean exitRequested;
            do {
                try {
                    exitRequested = showMenu(scanner, order);
                } catch (Exception e) {
                    InMemoryLogger.error("Unexpected error: " + e.getMessage());
                    System.out.println("!Something went wrong. Please try again.");
                    exitRequested = false;
                }
            } while (!exitRequested);

            InMemoryLogger.info("Checkout App terminated.");
            System.out.println("Thank you for shopping with us!");

            // Show logs
            System.out.println("\n=== Log History ===");
            InMemoryLogger.printLogs();
        }
    }

    private double readOrderAmount(Scanner scanner) {
        double amount = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print("Enter order amount: ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Amount cannot be empty.");
                }

                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than 0.");
                }

                validInput = true;
            } catch (NumberFormatException e) {
                InMemoryLogger.warn("Invalid amount entered.");
                System.out.println(" Invalid amount. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                InMemoryLogger.warn("Validation failed: " + e.getMessage());
                System.out.println(" " + e.getMessage());
            }
        } while (!validInput);

        InMemoryLogger.info("Order created with amount: " + amount);
        return amount;
    }

    private boolean showMenu(Scanner scanner, Order order) {
        System.out.println("\nChoose payment method: 1) Credit Card  2) PayPal  3) UPI  4) Checkout & Exit");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                handleCreditCardPayment(scanner, order);
                return false;

            case "2":
                handlePayPalPayment(scanner, order);
                return false;

            case "3":
                handleUPIPayment(scanner, order);
                return false;

            case "4":
                InMemoryLogger.info("User requested checkout & exit.");
                return true;

            default:
                InMemoryLogger.warn("Invalid menu choice: " + choice);
                System.out.println("Invalid choice. Try again.");
                return false;
        }
    }

    private void handleCreditCardPayment(Scanner scanner, Order order) {
        System.out.print("Enter Credit Card number (16 digits): ");
        String cardNumber = scanner.nextLine().trim();

        if (!cardNumber.matches("\\d{16}")) {
            InMemoryLogger.warn("Invalid credit card number entered.");
            System.out.println("Invalid card number. Must be 16 digits.");
            return;
        }

        order.setPaymentStrategy(new CreditCardPayment(cardNumber));
        order.checkout();
        InMemoryLogger.info("Payment completed using Credit Card.");
    }

    private void handlePayPalPayment(Scanner scanner, Order order) {
        System.out.print("Enter PayPal email: ");
        String email = scanner.nextLine().trim();

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
            InMemoryLogger.warn("Invalid PayPal email entered.");
            System.out.println("Invalid email address.");
            return;
        }

        order.setPaymentStrategy(new PayPalPayment(email));
        order.checkout();
        InMemoryLogger.info("Payment completed using PayPal.");
    }

    private void handleUPIPayment(Scanner scanner, Order order) {
        System.out.print("Enter UPI ID (e.g., user@bank): ");
        String upiId = scanner.nextLine().trim();

        if (!upiId.matches("^[\\w.-]+@[A-Za-z]+$")) {
            InMemoryLogger.warn("Invalid UPI ID entered.");
            System.out.println(" Invalid UPI ID format.");
            return;
        }

        order.setPaymentStrategy(new UPIPayment(upiId));
        order.checkout();
        InMemoryLogger.info("Payment completed using UPI.");
    }
}
