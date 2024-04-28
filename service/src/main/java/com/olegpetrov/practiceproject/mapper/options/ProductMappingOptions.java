package com.olegpetrov.practiceproject.mapper.options;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
public class ProductMappingOptions {

    public static final ProductMappingOptions DEFAULT_OPTIONS = ProductMappingOptions.builder().build();

    @Accessors(fluent = true)
    @Builder.Default
    private boolean includeBrand = true;

    @Accessors(fluent = true)
    @Builder.Default
    private boolean includeCategory = true;

}
