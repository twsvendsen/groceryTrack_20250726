package com.tws.grocerytracker.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class GroceryItem {
    private Integer uniqueId;
    private Commodity commodity;
    private BigDecimal costAtPurchase;
    private OffsetDateTime timeOfPurchase;
    private StoreLocation locationOfPurchase;
}
