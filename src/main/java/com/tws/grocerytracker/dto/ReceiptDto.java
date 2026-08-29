package com.tws.grocerytracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ReceiptDto {
    private String transactionDateTime;
    private List<GroceryItemDto> groceryItems;
    private String storeName;
    private String address;
    private BigDecimal totalCost;
    private BigDecimal subtotalCost;

}
