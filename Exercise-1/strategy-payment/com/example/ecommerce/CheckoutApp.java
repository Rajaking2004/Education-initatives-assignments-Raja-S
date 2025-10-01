package com.example.ecommerce;

import java.util.Scanner;

public class CheckoutApp {
    public static void main(String[] args) {
        CheckoutApp app = new CheckoutApp();
        app.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== E-Commerce Checkout (Strategy Pattern) ===");

            System.out.print("Enter order amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Order order = new Order(amount);

            boolean exitRequested;
            do {
                exitRequested = showMenu(scanner, order);
            } while (!exitRequested);

            System.out.println("Thank you for shopping with us!");
        }
    }

    private boolean showMenu(Scanner scanner, Order order) {
        System.out.println("\nChoose payment method: 1) Credit Card  2) PayPal  3) UPI  4) Checkout & Exit");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter Credit Card number: ");
                String cardNumber = scanner.nextLine();
                order.setPaymentStrategy(new CreditCardPayment(cardNumber));
                order.checkout();
                return false;

            case "2":
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                order.setPaymentStrategy(new PayPalPayment(email));
                order.checkout();
                return false;

            case "3":
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                order.setPaymentStrategy(new UPIPayment(upiId));
                order.checkout();
                return false;

            case "4":
                return true;

            default:
                System.out.println("Invalid choice. Try again.");
                return false;
        }
    }
}
