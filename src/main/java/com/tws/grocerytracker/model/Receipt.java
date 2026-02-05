package com.tws.grocerytracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private OffsetDateTime recordCreationDateTime;
    private OffsetDateTime transactionDateTime;
    private List<GroceryItem> groceryItems;
    private String storeLocationId;
    private BigDecimal totalCost;

    public Receipt(){};

    public Receipt(Builder builder) {
        this.id = builder.id;
        this.transactionDateTime = builder.transactionDateTime;
        this.groceryItems = builder.groceryItems;
        this.storeLocationId = builder.storeLocationId;
        this.totalCost = builder.totalCost;
        this.recordCreationDateTime = OffsetDateTime.now();
    }

    public static Builder builder(){ return new Builder(); }


    public static final class Builder {
        private Integer id;
        private OffsetDateTime transactionDateTime;
        private List<GroceryItem> groceryItems;
        private String storeLocationId;
        private BigDecimal totalCost;
        public Builder(){}

        public Builder id(Integer id) { this.id = id; return this; }
        public Builder transactionDateTime(OffsetDateTime transactionDateTime) { this.transactionDateTime = transactionDateTime; return this; }
        public Builder groceryItems(List<GroceryItem> groceryItems) { this.groceryItems = groceryItems; return this; }
        public Builder storeLocationId(String storeLocationId) { this.storeLocationId = storeLocationId; return this; }
        public Builder totalCost(BigDecimal totalCost) { this.totalCost = totalCost; return this; }
        public Receipt build() { return new Receipt(this); }
    }
}
