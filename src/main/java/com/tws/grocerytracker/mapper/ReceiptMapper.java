package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import io.micrometer.common.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
