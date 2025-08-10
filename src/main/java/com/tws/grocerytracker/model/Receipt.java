package com.tws.grocerytracker.model;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {

    private List<GroceryItem> groceryItems;
    private Double totalCost;
}
