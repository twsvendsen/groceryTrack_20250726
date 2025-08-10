package com.tws.grocerytracker.model;

import lombok.Data;

@Data
public class Commodity {
    private String itemName;
    private String brand;
    private Integer timesPurchased;
}
