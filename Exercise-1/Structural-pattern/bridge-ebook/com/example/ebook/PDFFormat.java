package com.example.ebook;

public class PDFFormat implements Format {
    @Override
    public void open(String title) throws FormatException {
        if (title == null || title.isEmpty()) {
            throw new FormatException("Invalid title for PDF format");
        }
        System.out.println("Opening PDF book: " + title);
    }
}
