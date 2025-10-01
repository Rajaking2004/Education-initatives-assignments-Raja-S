package com.example.ebook;

public class Novel extends EBook {
    public Novel(String title, Format format) {
        super(title, format);
    }

    @Override
    public void read() {
        try {
            System.out.print("Reading novel... ");
            format.open(title);
        } catch (FormatException e) {
            System.err.println("Error opening novel: " + e.getMessage());
        }
    }
}
