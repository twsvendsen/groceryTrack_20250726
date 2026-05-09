package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;

public class GroceryItemMapper {
    public GroceryItem mapGroceryItemDtoToGroceryItem(GroceryItemDto groceryItemDto, Receipt receipt, StoreLocation storeLocation, Commodity commodity) {
        // TODO: validate receipt was scanned correctly
        GroceryItem groceryItem = new GroceryItem.Builder()
                // TODO: error handling for below
                .receipt(receipt)
                .storeLocation(storeLocation)
                .commodity(commodity)
                .costAtPurchase(groceryItemDto.getCost())
                .build();

        return groceryItem;
    }
}
