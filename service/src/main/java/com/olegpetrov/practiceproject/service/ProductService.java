package com.olegpetrov.practiceproject.service;

import com.olegpetrov.practiceproject.dto.CategoryDto;
import com.olegpetrov.practiceproject.dto.ProductDto;
import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProductsBySearchCriteria(ProductSearchParams searchParams);

    void addProduct(ProductDto productDto);

    ProductDto getProductById(long id);

    void replenishProduct(long id, long quantity);
}
