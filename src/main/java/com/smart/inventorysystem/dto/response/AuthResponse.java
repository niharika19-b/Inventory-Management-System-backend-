package com.smart.inventorysystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private String role;
}
