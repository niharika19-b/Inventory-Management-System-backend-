package com.smart.inventorysystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertResponse {
    private String message;
    private String type; 
}