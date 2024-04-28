package com.olegpetrov.practiceproject.dto.query;

import com.olegpetrov.practiceproject.dto.enums.Sex;
import lombok.Data;

@Data
public class ProductSearchParams {

    private String name;

    private Sex sex;

    private Integer categoryId;

    private Integer brandId;

    private Integer page;

    private Integer pageSize;
}
