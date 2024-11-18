package com.example.shopproject.service;

import com.example.shopproject.entity.Product;
import com.example.shopproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts() {
        log.info("produce service list start...");
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Product getProduct(Long id) {
        log.info("produce service detail start...");
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));
    }

    @Override
    public void create(Product product) {
        log.info("produce service create start...");

        // 빌더 패턴
        Product newProduct = Product.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .imgsrc(product.getImgsrc())
                .description(product.getDescription())
                .build();
        productRepository.save(newProduct);
    }

    @Override
    public void update(Long id, Product product) {
        log.info("produce service update start...");

        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + id));

        updateProduct.setTitle(product.getTitle());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setImgsrc(product.getImgsrc());
        updateProduct.setDescription(product.getDescription());
    }

    @Override
    public void delete(Long id) {
        log.info("produce service delete start...");

        productRepository.deleteById(id);
    }

}
