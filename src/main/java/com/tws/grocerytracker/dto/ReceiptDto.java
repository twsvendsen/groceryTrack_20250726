package com.tws.grocerytracker.dto;


import java.math.BigDecimal;
import java.util.List;

public class ReceiptDto {
    // TODO: setup serialization id

    private String transactionDateTime;

    // TODO: convert to unique dto type which also carries price, count or weight etc.
    // need to research receipts to see what is appropriate
    private List<String> groceryItems;
    private BigDecimal totalCost;
    private String storeName;
    private String address;

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public List<String> getGroceryItems() {
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
