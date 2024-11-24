package com.iuh.se.services;

import com.iuh.se.entities.Product;

import java.util.List;

public interface Service {
    public void save(Product product);

    public void delete(Product product);

    public void update(Product product);

    public List<Product> getAll();
}
