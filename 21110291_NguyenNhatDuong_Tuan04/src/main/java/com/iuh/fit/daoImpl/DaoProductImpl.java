package com.iuh.fit.daoImpl;

import com.iuh.fit.beans.Product;
import com.iuh.fit.dao.DaoProduct;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProductImpl implements DaoProduct {
    private DataSource dataSource;

    public DaoProductImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() {
        String sql = "Select * from product";
        List<Product> list = new ArrayList<Product>();

        try{
            Connection con = this.dataSource.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                String image = rs.getString("image");
                product.setImage(image);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product getById(int id) {
        String sql = "Select * from product where id = ?";
        try{
            Connection con = this.dataSource.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                String image = rs.getString("image");
                product.setImage(image);
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        String sql = " Insert into `product` (name, price, image) values(?, ?, ?)";
        try{
            Connection con = this.dataSource.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, product.getName());
            pstm.setDouble(2, product.getPrice());
            pstm.setString(3, product.getImage());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
