package com.smart.inventorysystem.dto.request;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String sku;
    private BigDecimal price;
    private Long categoryId;
}
