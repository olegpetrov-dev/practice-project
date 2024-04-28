package com.olegpetrov.practiceproject.mapper;

import com.olegpetrov.practiceproject.dto.BrandDto;
import com.olegpetrov.practiceproject.entity.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public BrandDto toDto(final Brand entity) {
        return BrandDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

    public Brand toEntity(final BrandDto dto) {
        return Brand.builder().name(dto.getName()).build();
    }
}
