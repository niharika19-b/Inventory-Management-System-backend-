package com.smart.inventorysystem.service;

import java.util.List;
import com.smart.inventorysystem.entity.Product;

public interface AlertService {

    List<Product> getLowStockProducts();

    List<Product> getInactiveProductsWithStock();
}