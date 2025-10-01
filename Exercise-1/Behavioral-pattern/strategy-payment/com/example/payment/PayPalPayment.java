package com.example.payment;

public class PayPalPayment implements IPaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("🅿️ Processing PayPal payment of $" + amount + " for account: " + email);
    }
}
