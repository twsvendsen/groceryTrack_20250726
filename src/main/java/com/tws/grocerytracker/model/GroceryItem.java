package com.tws.grocerytracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "grocery_item")
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;

    @ManyToOne
    @JoinColumn(name = "store_location_id")
    private StoreLocation storeLocation;

    @Column(name = "cost_at_purchase")
    private BigDecimal costAtPurchase;

    public GroceryItem(){};

    public GroceryItem(Builder builder) {
        this.id = builder.uniqueId;
        this.receipt = builder.receipt;
        this.commodity = builder.commodity;
        this.storeLocation = builder.storeLocation;
        this.costAtPurchase = builder.costAtPurchase;
    }


    public static GroceryItem.Builder builder(){ return new GroceryItem.Builder(); }


    public static final class Builder {
        private Integer uniqueId;
        private Receipt receipt;
        private Commodity commodity;
        private StoreLocation storeLocation;
        private BigDecimal costAtPurchase;
        public Builder(){}

        public GroceryItem.Builder uniqueId(Integer id) { this.uniqueId = id; return this; }
        public GroceryItem.Builder receipt(Receipt receipt) { this.receipt = receipt; return this; }
        public GroceryItem.Builder commodity(Commodity commodity) { this.commodity = commodity; return this; }
        public GroceryItem.Builder storeLocation(StoreLocation storeLocation) { this.storeLocation = storeLocation; return this; }
        public GroceryItem.Builder costAtPurchase(BigDecimal costAtPurchase) { this.costAtPurchase = costAtPurchase; return this; }
        public GroceryItem build() { return new GroceryItem(this); }
    }
}
