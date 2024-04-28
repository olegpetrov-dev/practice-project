package com.olegpetrov.practiceproject.controller;

import com.olegpetrov.practiceproject.dto.CategoryDto;
import com.olegpetrov.practiceproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> getAllBrands() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> addCategory(@RequestBody final CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        return ResponseEntity.noContent().build();
    }
}
