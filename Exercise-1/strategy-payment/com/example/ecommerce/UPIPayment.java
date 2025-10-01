package com.example.ecommerce;

public class UPIPayment implements IPaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("📱 Processing UPI payment of $" + amount + " via UPI ID: " + upiId);
    }
}
