package com.smart.inventorysystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementResponse {
    private Long productId;
    private String productName;
    private int quantity;
    private String type; 
    private String movementDate;
}
