package com.olegpetrov.practiceproject.service.impl;

import com.olegpetrov.practiceproject.dto.ProductDto;
import com.olegpetrov.practiceproject.dto.query.ProductSearchParams;
import com.olegpetrov.practiceproject.entity.Product;
import com.olegpetrov.practiceproject.exception.ProductNotFoundException;
import com.olegpetrov.practiceproject.mapper.ProductMapper;
import com.olegpetrov.practiceproject.repository.ProductRepository;
import com.olegpetrov.practiceproject.repository.specs.ProductSpecification;
import com.olegpetrov.practiceproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Pageable DEFAULT_PAGEABLE = Pageable.ofSize(25);

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    private final List<ProductSpecification> productSpecifications;

    @Override
    public List<ProductDto> getAllProductsBySearchCriteria(final ProductSearchParams searchParams) {
        final Pageable pageable = buildPageable(searchParams);
        final List<Product> products = productSpecifications.stream()
                                                            .map(spec -> spec.get(searchParams))
                                                            .filter(Objects::nonNull)
                                                            .reduce(Specification::and)
                                                            .map(spec -> getProductsBySpec(spec, pageable))
                                                            .orElseGet(() -> getProductsNoSpec(pageable));

        return products.stream().map(productMapper::toDto).toList();
    }

    private Pageable buildPageable(final ProductSearchParams searchParams) {
        return searchParams.getPage() != null && searchParams.getPageSize() != null
               ? PageRequest.of(searchParams.getPage(), searchParams.getPageSize())
               : DEFAULT_PAGEABLE;
    }

    private List<Product> getProductsBySpec(final Specification<Product> spec, final Pageable pageable) {
        return productRepository.findAll(spec, pageable).getContent();
    }

    private List<Product> getProductsNoSpec(final Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public void addProduct(final ProductDto productDto) {
        final Product productEntity = productMapper.toEntity(productDto);
        productRepository.save(productEntity);
    }

    @Override
    public ProductDto getProductById(final long id) {
        return productRepository.findById(id).map(productMapper::toDto).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void replenishProduct(final long id, final long quantity) {
        productRepository.updateProductQuantity(id, quantity);
    }
}
