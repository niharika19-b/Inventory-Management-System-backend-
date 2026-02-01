package com.smart.inventorysystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()

                // API Info
                .info(new Info()
                        .title("Inventory System API")
                        .version("1.0")
                        .description("Smart Inventory Management Backend APIs"))

                // Enable JWT Authorize button
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))

                // Define Bearer JWT
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(
                                securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
}