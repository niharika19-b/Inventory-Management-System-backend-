package com.smart.inventorysystem.service;

import com.smart.inventorysystem.dto.request.AuthRequest;
import com.smart.inventorysystem.dto.response.AuthResponse;

public interface AuthService {
 AuthResponse register(AuthRequest request);
 
 AuthResponse login(AuthRequest request);
}
