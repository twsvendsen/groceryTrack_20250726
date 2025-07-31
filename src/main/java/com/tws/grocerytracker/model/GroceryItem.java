package com.tws.grocerytracker.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GroceryItem {
    Integer uniqueId;
    Commodity commodity;
    Double costAtPurchase;
    OffsetDateTime timeOfPurchase;
    StoreLocation locationOfPurchase;
}
