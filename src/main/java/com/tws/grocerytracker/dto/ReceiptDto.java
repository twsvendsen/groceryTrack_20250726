package com.tws.grocerytracker.dto;

import com.tws.grocerytracker.model.GroceryItem;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class ReceiptDto {
    // setup serialization id

    private String transactionDateTime;
    private List<String> groceryItems;
    private BigDecimal totalCost;

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public List<String> getGroceryItems() {
        return groceryItems;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}
