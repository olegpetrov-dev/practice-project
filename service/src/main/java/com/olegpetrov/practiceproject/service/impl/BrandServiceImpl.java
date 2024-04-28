package com.olegpetrov.practiceproject.service.impl;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.entity.Brand;
import com.olegpetrov.practiceproject.mapper.BrandMapper;
import com.olegpetrov.practiceproject.repository.BrandRepository;
import com.olegpetrov.practiceproject.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map(brandMapper::toDto).toList();
    }

    @Override
    public void addBrand(final BrandDto brandDto) {
        final Brand brandEntity = brandMapper.toEntity(brandDto);
        brandRepository.save(brandEntity);
    }
}
