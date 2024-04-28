package com.olegpetrov.practiceproject.repository.specs.impl;

import com.olegpetrov.practiceproject.dto.enums.Sex;
import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.entity.Product;
import com.olegpetrov.practiceproject.repository.specs.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SexProductSpecification implements ProductSpecification {

    @Override
    public Specification<Product> get(final ProductSearchParams productSearchParams) {
        final Sex sex = productSearchParams.getSex();
        if (sex != null) {
            return (root, query, builder) -> builder.equal(root.get(Product.Fields.sex), sex);
        } else {
            return null;
        }
    }
}
