package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.mapper.ReceiptMapper;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ReceiptRepository;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private ReceiptMapper receiptMapper;
    private ReceiptRepository receiptRepository;

    public void createReceipt(ReceiptDto receiptDto) {
        Receipt receipt = receiptMapper.mapReceiptDtoToReceipt(receiptDto);
//        receiptRepository.catalogueReceipt(receipt);
//        receiptRepository.closeConnection();
    }

    // update GroceryItem
    public void updateGroceryItem(GroceryItem groceryItem) {
        
    }
}
