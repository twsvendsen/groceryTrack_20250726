package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.model.Receipt;

import java.time.OffsetDateTime;

public class ReceiptMapper {

    public Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto) {
        // TODO: validate receipt was scanned correctly
        Receipt receipt = new Receipt.Builder()
                .id(1)
                // TODO: error handling for below
                .transactionDateTime(OffsetDateTime.parse(receiptDto.getTransactionDateTime()))
                .totalCost(receiptDto.getTotalCost())
                .build();

        return receipt;
    }
}
