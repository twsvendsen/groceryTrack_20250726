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

    public GroceryItem(){};

    public GroceryItem(Builder builder) {
        this.uniqueId = builder.uniqueId;
        this.receiptId = builder.receiptId;
        this.commodityId = builder.commodityId;
        this.storeLocationId = builder.storeLocationId;
        this.costAtPurchase = builder.costAtPurchase;
        this.timeOfPurchase = builder.timeOfPurchase;
    }


    public static GroceryItem.Builder builder(){ return new GroceryItem.Builder(); }


    public static final class Builder {
        private Integer uniqueId;
        private Integer receiptId;
        private Integer commodityId;
        private Integer storeLocationId;
        private BigDecimal costAtPurchase;
        private OffsetDateTime timeOfPurchase;
        public Builder(){}

        public GroceryItem.Builder uniqueId(Integer id) { this.uniqueId = id; return this; }
        public GroceryItem.Builder receiptId(Integer id) { this.receiptId = id; return this; }
        public GroceryItem.Builder commodityId(Integer id) { this.commodityId = id; return this; }
        public GroceryItem.Builder storeLocationId(Integer storeLocationId) { this.storeLocationId = storeLocationId; return this; }
        public GroceryItem.Builder costAtPurchase(BigDecimal costAtPurchase) { this.costAtPurchase = costAtPurchase; return this; }
        public GroceryItem.Builder timeOfPurchase(OffsetDateTime transactionDateTime) { this.timeOfPurchase = transactionDateTime; return this; }
        public GroceryItem build() { return new GroceryItem(this); }
    }
}
