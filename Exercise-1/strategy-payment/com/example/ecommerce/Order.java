package com.example.ecommerce;

public class Order {
    private double amount;
    private IPaymentStrategy paymentStrategy;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("⚠️ No payment method selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
