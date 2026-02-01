package com.smart.inventorysystem.service;

public interface ReportService {
  
  Object inventoryValuation();
  Object toMovingProducts();
  Object deadStock(int days);
}
