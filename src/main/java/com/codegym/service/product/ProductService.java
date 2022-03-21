package com.codegym.service.product;

import com.codegym.DAO.product.IProductDAO;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDAO productDAO;

    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productDAO.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Product product) {
        return productDAO.updateById(id, product);
    }
}
