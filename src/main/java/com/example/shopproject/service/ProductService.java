package com.example.shopproject.service;

import com.example.shopproject.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Long id);

    void create(Product product);

    void update(Long id, Product product);

    void delete(Long id);
}
