package com.olegpetrov.practiceproject.mapper;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.dto.CategoryDto;
import com.olegpetrov.practiceproject.dto.ProductDto;
import com.olegpetrov.practiceproject.entity.Product;
import com.olegpetrov.practiceproject.mapper.options.ProductMappingOptions;
import com.olegpetrov.practiceproject.repository.BrandRepository;
import com.olegpetrov.practiceproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ProductDto toDto(final Product entity) {
        return toDto(entity, ProductMappingOptions.DEFAULT_OPTIONS);
    }

    public ProductDto toDto(final Product entity, final ProductMappingOptions productMappingOptions) {

        BrandDto brand = null;
        if (productMappingOptions.includeBrand()) {
            brand = brandMapper.toDto(entity.getBrand());
        }

        CategoryDto category = null;
        if (productMappingOptions.includeBrand()) {
            category = categoryMapper.toDto(entity.getCategory());
        }

        return ProductDto.builder()
                         .id(entity.getId())
                         .name(entity.getName())
                         .description(entity.getDescription())
                         .brand(brand)
                         .category(category)
                         .price(entity.getPrice())
                         .sex(entity.getSex())
                         .quantity(entity.getQuantity())
                         .build();
    }

    public Product toEntity(final ProductDto productDto) {
        return Product.builder()
                      .name(productDto.getName())
                      .description(productDto.getDescription())
                      .brand(brandRepository.getReferenceById(productDto.getBrand().getId()))
                      .category(categoryRepository.getReferenceById(productDto.getCategory().getId()))
                      .price(productDto.getPrice())
                      .sex(productDto.getSex())
                      .build();
    }
}
