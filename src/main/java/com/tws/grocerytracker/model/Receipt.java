package com.tws.grocerytracker.model;

import lombok.Data;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbImmutable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@DynamoDbImmutable(builder = Receipt.Builder.class)
public class Receipt {
    private Integer id;
    private OffsetDateTime dateTime;
    private List<GroceryItem> groceryItems;
    private BigDecimal totalCost;

    private Receipt(Builder builder) {
        this.id = builder.id;
        this.dateTime = builder.dateTime;
        this.groceryItems = builder.groceryItems;
        this.totalCost = builder.totalCost;
    }

    public static Builder builder(){ return new Builder(); }

    @DynamoDbPartitionKey
    public Integer getId() { return id; }

    @DynamoDbSortKey
    public OffsetDateTime getDateTime() { return dateTime; }


    public static final class Builder {
        private Integer id;
        private OffsetDateTime dateTime;
        private List<GroceryItem> groceryItems;
        private BigDecimal totalCost;
        private Builder(){}

        public Builder id(Integer id) { this.id = id; return this; }
        public Builder dateTime(OffsetDateTime dateTime) { this.dateTime = dateTime; return this; }
        public Builder groceryItems(List<GroceryItem> groceryItems) { this.groceryItems = groceryItems; return this; }
        public Builder totalCost(BigDecimal totalCost) { this.totalCost = totalCost; return this; }
        public Receipt build() { return new Receipt(this); }
    }
}
