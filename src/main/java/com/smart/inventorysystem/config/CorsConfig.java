package com.smart.inventorysystem.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();  

        // Allow frontend origin exactly
        config.setAllowedOriginPatterns(List.of("http://localhost:62904"));

        // Allow credentials (cookies, authorization headers)
        config.setAllowCredentials(true);

        // Allow all standard headers
        config.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        
        // Allow all standard methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Apply CORS config to all paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
