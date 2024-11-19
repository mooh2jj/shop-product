package com.example.shopproject.controller;

import com.example.shopproject.dto.ProductDTO;
import com.example.shopproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductDTO>> list() {

        // 시간을 6초 정도 딜레이
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return ResponseEntity.ok(productService.getProducts());
    }


    /**
     * 상품 상세 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> detail(@PathVariable Long id) {

        // 시간을 6초 정도 딜레이
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(productService.getProduct(id));
    }

    /**
     * 상품 등록
     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDTO product) {
        log.info("product add start...: {}", product);
        productService.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
    }


    /**
     * 상품 수정
     *
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO product) {
        log.info("product update start...: {}", product);
        productService.update(id, product);

        return ResponseEntity.status(HttpStatus.OK).build(); // 200
    }

    /**
     * 상품 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("product delete start...: {}", id);
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build(); // 200
    }
}
