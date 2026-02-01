package com.smart.inventorysystem.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.smart.inventorysystem.repository.ProductRepository;
import com.smart.inventorysystem.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final ProductRepository productRepository;


    @GetMapping("/low-stock")
    public List<Product> lowStock() {

        return productRepository.findAll()
                .stream()
                .filter(p -> p.getCurrentStock() <= p.getReorderLevel())
                .collect(Collectors.toList());
    }
}