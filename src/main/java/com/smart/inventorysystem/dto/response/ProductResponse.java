package com.smart.inventorysystem.dto.response;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String sku;
    private BigDecimal price;
    private String categoryName;
}
