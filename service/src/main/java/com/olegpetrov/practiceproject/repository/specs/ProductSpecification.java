package com.olegpetrov.practiceproject.repository.specs;

import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface ProductSpecification {

    Specification<Product> get(ProductSearchParams productSearchParams);
}
