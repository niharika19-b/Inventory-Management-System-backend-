package com.smart.inventorysystem.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.smart.inventorysystem.entity.Product;
import com.smart.inventorysystem.repository.ProductRepository;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final ProductRepository productRepository;


    @PutMapping("/update/{id}/{qty}")
    public Product updateStock(@PathVariable int id, @PathVariable int qty) {

        Product p = productRepository.findById(id).orElseThrow();

        p.setCurrentStock(qty);

        return productRepository.save(p);
    }
}