package com.example.ebook;

public class Textbook extends EBook {
    public Textbook(String title, Format format) {
        super(title, format);
    }

    @Override
    public void read() {
        try {
            System.out.print("Studying textbook... ");
            format.open(title);
        } catch (FormatException e) {
            System.err.println("Error opening textbook: " + e.getMessage());
        }
    }
}
