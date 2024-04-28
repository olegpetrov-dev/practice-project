package com.olegpetrov.practiceproject.repository.specs.impl;

import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.entity.Category;
import com.olegpetrov.practiceproject.entity.Product;
import com.olegpetrov.practiceproject.repository.specs.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CategoryProductSpecification implements ProductSpecification {

    @Override
    public Specification<Product> get(final ProductSearchParams productSearchParams) {
        final Integer categoryId = productSearchParams.getCategoryId();
        if (categoryId != null) {
            return (root, query, builder) -> builder.equal(root.get(Product.Fields.category).get(Category.Fields.id), categoryId);
        } else {
            return null;
        }
    }
}
