package com.example.ebook;

public class EPUBFormat implements Format {
    @Override
    public void open(String title) throws FormatException {
        if (title == null || title.isEmpty()) {
            throw new FormatException("Invalid title for EPUB format");
        }
        System.out.println("Opening EPUB book: " + title);
    }
}
