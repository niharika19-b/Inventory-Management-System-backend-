package com.smart.inventorysystem.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockRequest {
    private Long productId;
    private int quantity;
    private String type; 
}
