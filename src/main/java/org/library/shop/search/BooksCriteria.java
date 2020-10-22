package org.library.shop.search;

public class BooksCriteria {

    private String isbn;
    private String author;
    private String name;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
