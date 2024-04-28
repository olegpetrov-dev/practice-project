package com.olegpetrov.practiceproject.service.impl;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.dto.CategoryDto;
import com.olegpetrov.practiceproject.entity.Brand;
import com.olegpetrov.practiceproject.entity.Category;
import com.olegpetrov.practiceproject.mapper.BrandMapper;
import com.olegpetrov.practiceproject.mapper.CategoryMapper;
import com.olegpetrov.practiceproject.repository.BrandRepository;
import com.olegpetrov.practiceproject.repository.CategoryRepository;
import com.olegpetrov.practiceproject.service.BrandService;
import com.olegpetrov.practiceproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }

    @Override
    public void addCategory(final CategoryDto categoryDto) {
        final Category categoryEntity = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(categoryEntity);
    }
}
