package com.dao;

import com.bean.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);
    public void update(int id);
    public void delete(int id);
    public List<Book> findAll();
    public Book findById(int id);
}
