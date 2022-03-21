package com.codegym.DAO.product;

import com.codegym.DAO.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public static final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product (name, price, description, image) VALUES (?, ?, ?, ?)";
    public static final String DELETE_BY_ID = "DELETE FROM product WHERE id = ?";
    public static final String UPDATE_PRODUCT_BY_ID = "UPDATE product SET name = ?, price = ?, description = ?, image = ? WHERE id = ?";
    private Connection conn = DBConnection.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                Product product = new Product(id, name, price, description, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int inputId) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, inputId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                product = new Product(id, name, price, description, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_NEW_PRODUCT);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getImage());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateById(int id, Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT_BY_ID);
            ps.setString(1, product.getImage());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getImage());
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
