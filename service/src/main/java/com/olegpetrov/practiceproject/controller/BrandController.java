package com.olegpetrov.practiceproject.controller;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/brands")
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping("/brands")
    public ResponseEntity<Void> addBrand(@RequestBody final BrandDto brandDto) {
        brandService.addBrand(brandDto);
        return ResponseEntity.noContent().build();
    }
}
