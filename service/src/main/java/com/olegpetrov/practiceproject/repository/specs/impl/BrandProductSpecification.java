package com.olegpetrov.practiceproject.repository.specs.impl;

import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.entity.Category;
import com.olegpetrov.practiceproject.entity.Product;
import com.olegpetrov.practiceproject.repository.specs.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BrandProductSpecification implements ProductSpecification {

    @Override
    public Specification<Product> get(final ProductSearchParams productSearchParams) {
        final Integer brandId = productSearchParams.getBrandId();
        if (brandId != null) {
            return (root, query, builder) -> builder.equal(root.get(Product.Fields.brand).get(Category.Fields.id), brandId);
        } else {
            return null;
        }
    }
}
