package com.smart.inventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.smart.inventorysystem.entity.Product;
import com.smart.inventorysystem.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

   
    @GetMapping
    public Page<Product> getAll(
            @RequestParam(defaultValue = "0") int page,   
            @RequestParam(defaultValue = "5") int size    
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @PostMapping("/add")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Deleted";
    }
}
