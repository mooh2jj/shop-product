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

    // entity -> dty
    default ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .imgsrc(product.getImgsrc())
                .description(product.getDescription())
                .build();
    }

    // dto -> entity
    default Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .imgsrc(productDTO.getImgsrc())
                .description(productDTO.getDescription())
                .build();
    }
}
