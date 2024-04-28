package com.olegpetrov.practiceproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDto {

    private Integer id;

    private String name;
}
