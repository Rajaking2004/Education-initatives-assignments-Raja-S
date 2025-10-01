package com.example.ecommerce;

public class Customer implements Observer {
    private String name;
    private NotificationType notificationType;

    public Customer(String name, NotificationType type) {
        this.name = name;
        this.notificationType = type;
    }

    @Override
    public void update(Product product) {
        String method = notificationType == NotificationType.EMAIL ? "Email" : "SMS";
        System.out.println("🔔 Notification to " + name + " via " + method +
                ": Product '" + product.getName() + "' is back in stock!");
    }
}
