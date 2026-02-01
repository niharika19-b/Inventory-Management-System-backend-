package com.smart.inventorysystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {
    private String title;
    private String generatedAt;
    private Object data;
}
