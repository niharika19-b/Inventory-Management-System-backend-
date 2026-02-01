package com.smart.inventorysystem.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest {
    private int page;
    private int size;
    private String sortBy;
    private String direction; 
}
