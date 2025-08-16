package com.tws.grocerytracker.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class StoreLocation {
    private String storeName;
    private String address;
}
