package com.tws.grocerytracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "groceryItem")
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uniqueId;

    @Column(name = "receiptId")
    private Integer receiptId;

    @Column(name = "receiptId")
    private Integer commodityId;

    @Column(name = "storeLocationId")
    private Integer storeLocationId;

    @Column(name = "costAtPurchase")
    private BigDecimal costAtPurchase;

    @Column(name = "timeOfPurchase")
    private OffsetDateTime timeOfPurchase;
}
