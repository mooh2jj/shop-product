package com.example.shopproject.controller;

import com.example.shopproject.dto.ProductDTO;
import com.example.shopproject.entity.Product;
import com.example.shopproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // service DI (생성자 주입)
    private final ProductService productService;

    /**
     * 상품 목록 조회 /api/products
     * @return 상품 목록
     */
    @GetMapping
    public List<ProductDTO> list() {
        return productService.getProducts();
    }


    /**
     * 상품 상세 조회
     */
    @GetMapping("/{id}")
    public ProductDTO detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    /**
     * 상품 등록
     */
    @PostMapping
    public void add(@RequestBody ProductDTO product) {
        log.info("product add start...: {}", product);
        productService.create(product);
    }


    /**
     * 상품 수정
     *
     */
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductDTO product) {
        log.info("product update start...: {}", product);
        productService.update(id, product);
    }

    /**
     * 상품 삭제
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("product delete start...: {}", id);
        productService.delete(id);
    }
}
