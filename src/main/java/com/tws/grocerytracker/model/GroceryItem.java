package com.tws.grocerytracker.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@DynamoDbBean
public class GroceryItem {
    private Integer uniqueId;
    private Commodity commodity;
    private BigDecimal costAtPurchase;
    private OffsetDateTime timeOfPurchase;
    private StoreLocation locationOfPurchase;
}
