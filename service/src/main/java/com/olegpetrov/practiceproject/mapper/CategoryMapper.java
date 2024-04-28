package com.olegpetrov.practiceproject.mapper;

import com.olegpetrov.practiceproject.dto.CategoryDto;
import com.olegpetrov.practiceproject.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto toDto(final Category entity) {
        return CategoryDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

    public Category toEntity(final CategoryDto dto) {
        return Category.builder().name(dto.getName()).build();
    }
}
