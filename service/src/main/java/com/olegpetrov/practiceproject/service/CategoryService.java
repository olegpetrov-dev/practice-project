package com.olegpetrov.practiceproject.service;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    void addCategory(CategoryDto categoryDto);
}
