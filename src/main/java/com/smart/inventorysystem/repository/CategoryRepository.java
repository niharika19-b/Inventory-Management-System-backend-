package com.smart.inventorysystem.repository;

import java.util.Optional;

import com.smart.inventorysystem.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

Optional<Category> findByName(String name);


boolean existsByName(String name);
}
