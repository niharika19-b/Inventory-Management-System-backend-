package com.smart.inventorysystem.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.smart.inventorysystem.repository.ProductRepository;

import java.util.Map;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ProductRepository productRepository;


    @GetMapping("/total-products")
    public Map<String, Long> totalProducts() {

        long count = productRepository.count();

        return Map.of("totalProducts", count);
    }
}