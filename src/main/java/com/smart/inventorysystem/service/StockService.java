package com.smart.inventorysystem.service;

public interface StockService {

    void stockIn(int productId, int quantity, String reason);

    void stockOut(int productId, int quantity, String reason);

    void adjust(int productId, int newQuantity, String reason);
}