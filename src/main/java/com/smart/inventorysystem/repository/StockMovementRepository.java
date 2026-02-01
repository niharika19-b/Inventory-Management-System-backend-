package com.smart.inventorysystem.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.smart.inventorysystem.entity.Product;
import com.smart.inventorysystem.entity.StockMovement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {


List<StockMovement> findByProduct(Product product);


List<StockMovement> findByTimestampBetween(LocalDateTime start, LocalDateTime end);


List<StockMovement> findTop10ByOrderByTimestampDesc();
}
