package com.olegpetrov.practiceproject.dto;

import com.olegpetrov.practiceproject.dto.enums.Sex;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Integer id;

    private String name;

    private String description;

    private CategoryDto category;

    private BrandDto brand;

    private Double price;

    private Sex sex;

    private Integer quantity;
}
