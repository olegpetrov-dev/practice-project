package com.olegpetrov.practiceproject.service;

import com.olegpetrov.practiceproject.dto.BrandDto;

import java.util.List;

public interface BrandService {

    List<BrandDto> getAllBrands();

    void addBrand(BrandDto brand);
}
