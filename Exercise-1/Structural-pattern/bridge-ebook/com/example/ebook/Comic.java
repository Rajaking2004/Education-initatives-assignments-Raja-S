package com.example.ebook;

public class Comic extends EBook {
    public Comic(String title, Format format) {
        super(title, format);
    }

    @Override
    public void read() {
        try {
            System.out.print("Enjoying comic... ");
            format.open(title);
        } catch (FormatException e) {
            System.err.println("Error opening comic: " + e.getMessage());
        }
    }
}
