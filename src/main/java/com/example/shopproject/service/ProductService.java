package com.example.shopproject.service;

import com.example.shopproject.dto.ProductDTO;
import com.example.shopproject.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    ProductDTO getProduct(Long id);

    void create(ProductDTO productDTO);

    void update(Long id, ProductDTO product);

    void delete(Long id);
}
