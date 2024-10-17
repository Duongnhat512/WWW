package com.bean;

public class BookCart {
    private Book book;
    private int quantity;

    public BookCart() {
    }

    public BookCart(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "BookCart{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
