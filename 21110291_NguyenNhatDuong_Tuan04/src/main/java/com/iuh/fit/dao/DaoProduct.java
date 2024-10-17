package com.iuh.fit.dao;

import com.iuh.fit.beans.Product;

import java.util.List;

public interface DaoProduct {
    public List<Product> findAll();

    public Product getById(int id);

    public void addProduct(Product product);
}
