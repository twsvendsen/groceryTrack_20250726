package com.tws.grocerytracker.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class Commodity {
    private String itemName;
    private String brand;
    private Integer timesPurchased;
}
