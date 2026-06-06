package com.tws.grocerytracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "receipt",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"transactionDateTime", "storeLocationId"})
        }
)
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recordCreationDateTime")
    private OffsetDateTime recordCreationDateTime;

    @Column(name = "transactionDateTime")
    private OffsetDateTime transactionDateTime;

    @OneToMany
    @Column(name = "groceryItems")
    private List<GroceryItem> groceryItems;

    @ManyToOne
    @Column(name = "storeLocationId")
    private StoreLocation storeLocation;

    @Column(name = "totalCost")
    private BigDecimal totalCost;

    public Receipt(){};

    public Receipt(Builder builder) {
        this.id = builder.id;
        this.transactionDateTime = builder.transactionDateTime;
        this.groceryItems = builder.groceryItems;
        this.storeLocation = builder.storeLocation;
        this.totalCost = builder.totalCost;
        this.recordCreationDateTime = OffsetDateTime.now();
    }

    public static Builder builder(){ return new Builder(); }


    public static final class Builder {
        private Integer id;
        private OffsetDateTime transactionDateTime;
        private List<GroceryItem> groceryItems;
        private StoreLocation storeLocation;
        private BigDecimal totalCost;
        public Builder(){}

        public Builder id(Integer id) { this.id = id; return this; }
        public Builder transactionDateTime(OffsetDateTime transactionDateTime) { this.transactionDateTime = transactionDateTime; return this; }
        public Builder groceryItems(List<GroceryItem> groceryItems) { this.groceryItems = groceryItems; return this; }
        public Builder storeLocation(StoreLocation storeLocation) { this.storeLocation = storeLocation; return this; }
        public Builder totalCost(BigDecimal totalCost) { this.totalCost = totalCost; return this; }
        public Receipt build() { return new Receipt(this); }
    }
}
