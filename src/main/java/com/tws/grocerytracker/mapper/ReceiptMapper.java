package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;

import java.time.OffsetDateTime;
import java.util.List;

public class ReceiptMapper {

    public Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto, StoreLocation storeLocation, List<GroceryItem> groceryItems) {
        // TODO: validate receipt was scanned correctly
        Receipt receipt = new Receipt.Builder()
                // TODO: error handling for below
                .transactionDateTime(OffsetDateTime.parse(receiptDto.getTransactionDateTime()))
                .totalCost(receiptDto.getTotalCost())
                .storeLocationId(storeLocation.getId())
                .groceryItems(groceryItems)
                .build();

        return receipt;
    }
}
