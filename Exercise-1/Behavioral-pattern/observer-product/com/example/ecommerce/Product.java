package com.example.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private boolean inStock;
    private List<Observer> observers;

    public Product(String name) {
        this.name = name;
        this.inStock = false;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isInStock() {
        return inStock;
    }

    // attach observer
    public void subscribe(Observer customer) {
        observers.add(customer);
        System.out.println("✅ " + ((Customer)customer).getClass().getSimpleName() + " subscribed to " + name);
    }

    // detach observer
    public void unsubscribe(Observer customer) {
        observers.remove(customer);
    }

    // notify all observers
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // change state
    public void restock() {
        this.inStock = true;
        System.out.println("\n📦 Product '" + name + "' is now in stock!");
        notifyObservers();
    }
}
