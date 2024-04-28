package com.olegpetrov.practiceproject.controller;

import com.olegpetrov.practiceproject.dto.ProductDto;
import com.olegpetrov.practiceproject.dto.ProductReplenishmentDto;
import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody final ProductDto productDto) {
        productService.addProduct(productDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable final long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProductsBySearchCriteria(@ModelAttribute ProductSearchParams searchParams) {
        return productService.getAllProductsBySearchCriteria(searchParams);
    }

    @PostMapping("/products/replenishment/{id}")
    public ResponseEntity<Void> replenishProduct(@PathVariable final long id,
                                                 @RequestBody final ProductReplenishmentDto productReplenishmentDto) {
        productService.replenishProduct(id, productReplenishmentDto.getQuantity());
        return ResponseEntity.noContent().build();
    }
}
