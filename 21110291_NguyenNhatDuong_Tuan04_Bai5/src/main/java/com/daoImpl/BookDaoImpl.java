package com.daoImpl;

import com.bean.Book;
import com.dao.BookDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private DataSource dataSource;

    public BookDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Book book) {
        String sql = "INSERT INTO book (name, author, price, quantity, image) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, book.getName());
            stm.setString(2, book.getAuthor());
            stm.setDouble(3, book.getPrice());
            stm.setInt(4, book.getQuantity());
            stm.setString(5, book.getImage());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Book> findAll() {
        String sql = "Select * from book";
        List<Book> books = new ArrayList<Book>();
        try {
            Connection connection = dataSource.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setQuantity(rs.getInt("quantity"));
                book.setImage(rs.getString("image"));
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findById(int id) {
        String sql = "Select * from book where id = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setQuantity(rs.getInt("quantity"));
                book.setImage(rs.getString("image"));
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
