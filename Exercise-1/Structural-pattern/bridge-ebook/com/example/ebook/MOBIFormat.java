package com.example.ebook;

public class MOBIFormat implements Format {
    @Override
    public void open(String title) throws FormatException {
        if (title == null || title.isEmpty()) {
            throw new FormatException("Invalid title for MOBI format");
        }
        System.out.println("Opening MOBI book: " + title);
    }
}
