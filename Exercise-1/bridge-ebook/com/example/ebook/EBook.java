package com.example.ebook;

public abstract class EBook {
    protected Format format;
    protected String title;

    public EBook(String title, Format format) {
        this.title = title;
        this.format = format;
    }

    public abstract void read();
}
