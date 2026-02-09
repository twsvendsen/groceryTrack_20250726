package com.tws.grocerytracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "groceryItem")
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uniqueId;

    private Integer receiptId;
    private Integer commodityId;
    private Integer storeLocationId;
    private BigDecimal costAtPurchase;
    private OffsetDateTime timeOfPurchase;
}
