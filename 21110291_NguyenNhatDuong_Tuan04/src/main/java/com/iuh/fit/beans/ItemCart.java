package com.iuh.fit.beans;

public class ItemCart {
    private Product product;
    private int quantity;

    public ItemCart() {
    }

    public ItemCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemCart{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
