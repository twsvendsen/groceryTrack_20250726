package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;

import java.time.OffsetDateTime;

public class ReceiptMapper {

    public Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto, StoreLocation storeLocation) {

        return new Receipt.Builder()
                // TODO: error handling for below
                .transactionDateTime(OffsetDateTime.parse(receiptDto.getTransactionDateTime()))
                .totalCost(receiptDto.getTotalCost())
                .subtotalCost(receiptDto.getSubtotalCost())
                .storeLocation(storeLocation)
                .build();
    }
}
