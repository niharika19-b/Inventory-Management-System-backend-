package com.smart.inventorysystem.controller;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.smart.inventorysystem.entity.*;
import com.smart.inventorysystem.repository.*;
import com.smart.inventorysystem.security.JwtUtil;

import java.util.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // ================= LOGIN =================
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        logger.info("Login attempt for username: {}", username);

        try {
            // Authenticate user
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            logger.info("Authentication successful for username: {}", username);

            // Generate JWT
            String token = jwtUtil.generateToken(username);
            logger.info("JWT generated for username: {}", username);

            Map<String, Object> response = Map.of(
                "token", token,
                "username", username
            );
            logger.debug("Login response: {}", response);

            return response;

        } catch (BadCredentialsException ex) {
            logger.warn("Login failed for username {}: Bad credentials", username);
            throw ex;
        } catch (Exception ex) {
            logger.error("Login failed for username {}: {}", username, ex.getMessage(), ex);
            throw ex;
        }
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        String roleName = req.get("ROLE_");
        logger.info("Register attempt: username={}, role={}", username, roleName);

        try {
            // Fetch role
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> {
                        logger.error("Role not found: {}", roleName);
                        return new RuntimeException("Role not found");
                    });
            logger.info("Role fetched successfully: {}", role.getName());

            // Create user entity
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(Set.of(role));
            user.setEnabled(true);

            // Save user
            userRepository.save(user);
            logger.info("User registered successfully: {}", username);

            return "User registered successfully";

        } catch (Exception ex) {
            logger.error("Error registering user {}: {}", username, ex.getMessage(), ex);
            throw ex;
        }
    }
}
