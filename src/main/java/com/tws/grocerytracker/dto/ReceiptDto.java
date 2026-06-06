package com.tws.grocerytracker.dto;


import java.math.BigDecimal;
import java.util.List;

public class ReceiptDto {
    private String transactionDateTime;
    private List<GroceryItemDto> groceryItems;
    private BigDecimal totalCost;
    private String storeName;
    private String address;

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public List<GroceryItemDto> getGroceryItems() {
        return groceryItems;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return address;
    }
}
